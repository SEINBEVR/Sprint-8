package com.example.retailer.api.distributor

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

/**
 * Описание заказа
 */
@Entity
@Table(name = "orders")
data class Order(
    /**
     * Уникальный идентификатор заказа на стороне ретейлера
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    val id: String?,

    /**
     * Произвольный адрес доставки
     */
    @Column
    val address: String,

    /**
     * Произвольный получатель доставки
     */
    @Column
    val recipient: String,

    /**
     * Список заказанных товаров
     */
    @OneToMany
    @Cascade(CascadeType.ALL)
    val items: List<Item>
)