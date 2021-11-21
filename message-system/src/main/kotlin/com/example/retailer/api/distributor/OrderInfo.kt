package com.example.retailer.api.distributor

import javax.persistence.*

/**
 * Уведомление об изменении заказа
 */
@Entity
data class OrderInfo(

    /**
     * Уникальный идентификатор заказа
     *
     * @see com.example.retailer.api.distributor.Item#id
     */
    @Id
    val orderId: String,

    /**
     * Статус заказа:
     *  Created
     *
     */
    @Enumerated(EnumType.ORDINAL)
    var status: OrderStatus,

    /**
     * Контрольная сумма
     */
    val signature: String,

)