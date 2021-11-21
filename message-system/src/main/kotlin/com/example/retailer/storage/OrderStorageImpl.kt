package com.example.retailer.storage

import com.example.retailer.api.distributor.Order
import com.example.retailer.api.distributor.OrderInfo
import com.example.retailer.api.distributor.OrderStatus
import com.example.retailer.storage.repository.OrderInfoRepository
import com.example.retailer.storage.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class OrderStorageImpl: OrderStorage {
    @Autowired
    lateinit var orderRepository: OrderRepository
    @Autowired
    lateinit var orderInfoRepository: OrderInfoRepository


    override fun createOrder(draftOrder: Order): PlaceOrderData {
        val order = orderRepository.save(draftOrder)
        val orderInfo = orderInfoRepository
            .save(OrderInfo(order.id!!, OrderStatus.SENT, "signature"))
        return PlaceOrderData(order, orderInfo)
    }

    override fun updateOrder(order: OrderInfo): Boolean {
        return if (orderInfoRepository.findById(order.orderId).isPresent) {
            orderInfoRepository.save(order)
            true
        }
        else false
    }

    override fun getOrderInfo(id: String): OrderInfo? = orderInfoRepository.findByIdOrNull(id)
}