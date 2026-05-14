package com.example.projectBackend.Controller;

import com.example.projectBackend.DTO.FarmerOrderDTO;
import com.example.projectBackend.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/farmer")
@CrossOrigin(origins = "*")
public class FarmerOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<?> getLoggedInFarmerOrders(
            @RequestHeader(value = "X-Farmer-Id", required = false) Long farmerId,
            @RequestHeader(value = "Authorization", required = false) String authorizationHeader) {

        Long resolvedFarmerId = farmerId != null ? farmerId : resolveFarmerIdFromAuthorization(authorizationHeader);

        if (resolvedFarmerId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Farmer authentication is required");
        }

        List<FarmerOrderDTO> orders = orderService.getFarmerOrderDetails(resolvedFarmerId);
        return ResponseEntity.ok(orders);
    }

    private Long resolveFarmerIdFromAuthorization(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return null;
        }

        String token = authorizationHeader.substring(7).trim();
        try {
            return Long.parseLong(token);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
