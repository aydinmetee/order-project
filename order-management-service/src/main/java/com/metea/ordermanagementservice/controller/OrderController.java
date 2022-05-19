package com.metea.ordermanagementservice.controller;

import com.metea.ordermanagementservice.dto.OrderDetailReadDTO;
import com.metea.ordermanagementservice.dto.OrderDetailSearchCriteriaDTO;
import com.metea.ordermanagementservice.dto.OrderDetailWriteDTO;
import com.metea.ordermanagementservice.dto.OrderMasterReadDTO;
import com.metea.ordermanagementservice.dto.OrderMasterSearchCriteriaDTO;
import com.metea.ordermanagementservice.dto.OrderMasterWriteDTO;
import com.metea.ordermanagementservice.serviceview.OrderDetailServiceView;
import com.metea.ordermanagementservice.serviceview.OrderMasterServiceView;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mete Aydin
 * @date 18.10.2021
 */

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderMasterServiceView orderMasterServiceView;
    private final OrderDetailServiceView orderDetailServiceView;

    @PostMapping()
    public ResponseEntity<OrderMasterReadDTO> create(@RequestBody OrderMasterWriteDTO orderMasterWriteDTO) {
        return ResponseEntity.ok(orderMasterServiceView.create(orderMasterWriteDTO));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<OrderMasterReadDTO> delete(@PathVariable("orderId") Long orderId) {
        return ResponseEntity.ok(orderMasterServiceView.delete(orderId));
    }

    @PostMapping("/search")
    public ResponseEntity<Page<OrderMasterReadDTO>> search(@RequestBody() OrderMasterSearchCriteriaDTO filter,
                                                           @RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(orderMasterServiceView.search(filter, PageRequest.of(page, size)));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderMasterReadDTO> markAsComplete(@PathVariable("orderId") Long orderId) {
        return ResponseEntity.ok(orderMasterServiceView.markAsComplete(orderId));
    }

    @PostMapping("/{orderId}/detail")
    public ResponseEntity<OrderDetailReadDTO> createDetail(@RequestBody OrderDetailWriteDTO orderDetailWriteDTO,
                                                           @PathVariable("orderId") Long orderId) {
        orderDetailWriteDTO.setOrderMasterId(orderId);
        return ResponseEntity.ok(orderDetailServiceView.create(orderDetailWriteDTO));
    }

    @DeleteMapping("/{orderId}/detail/{detailId}")
    public ResponseEntity<OrderDetailReadDTO> deleteDetail(@PathVariable("detailId") Long detailId) {
        return ResponseEntity.ok(orderDetailServiceView.delete(detailId));
    }

    @PostMapping("/{orderId}/detail/search")
    public ResponseEntity<Page<OrderDetailReadDTO>> searchDetails(@RequestBody() OrderDetailSearchCriteriaDTO filter,
                                                                  @RequestParam(defaultValue = "0") int page,
                                                                  @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(orderDetailServiceView.search(filter, PageRequest.of(page, size)));
    }
}
