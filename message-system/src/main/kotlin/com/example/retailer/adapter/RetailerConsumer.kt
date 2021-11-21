package com.example.retailer.adapter

interface RetailerConsumer {
    fun receive(message: String)
}