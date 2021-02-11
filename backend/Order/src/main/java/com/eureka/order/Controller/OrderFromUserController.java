package com.eureka.order.Controller;

import com.eureka.order.Entity.OrderDetailEntity;
import com.eureka.order.Entity.OrderEntity;
import com.eureka.order.dto.Response;
import com.eureka.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderFromUserController {

    private final OrderService orderService;

    public OrderFromUserController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value ="userid/{userId}")
    public Response getOrdersByUserId(@PathVariable("userId") String userId, @RequestParam Integer page,Integer size){

        System.out.println("getorders : "+userId);
        Response response;
        try {
            response= new Response("success", "조회성공", orderService.getOrdersByUserId(userId,page,size)) ;
        } catch (Exception e) {
            response= new Response("error", e.getMessage(), null) ;
        }
        return response;

    }

    @GetMapping(value ="userid/{userId}/all")
    public Response getOrders(@PathVariable("userId") String userId){

        System.out.println("getorders : "+userId);
        Response response;
        try {
            response= new Response("success", "조회성공", orderService.getOrdersByUserId(userId)) ;
        } catch (Exception e) {
            response= new Response("error", e.getMessage(), null) ;
        }
        return response;

    }

    @PostMapping()
    public Response saveOrders( @RequestBody OrderEntity orderEntity) {

        System.out.println("saveorders : "  +orderEntity);
        Response response;
        try {
            orderService.saveOrder(orderEntity);
            response= new Response("success", "등록성공", orderService.getOrdersByUserId(orderEntity.getUserId())) ;
        } catch (Exception e) {
            response= new Response("error", e.getMessage(), null) ;
        }
        return response;
    }

    @PutMapping ()
    public Response updateOrders(@RequestBody OrderDetailEntity orderDetailEntity) {

        System.out.println("updateOrders : "  +orderDetailEntity);
        Response response;
        try {
            orderService.updateOrder(orderDetailEntity);
            response= new Response("success", "변경성공", orderService.getOrdersByUserId(orderDetailEntity.getOrderId())) ;
        } catch (Exception e) {
            response= new Response("error", e.getMessage(), null) ;
        }
        return response;
    }
}