package com.biacode.biacentric.vcs.commons.json

import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Created by Arthur Asatryan.
 * Date: 11/12/17
 * Time: 7:03 PM
 */
object JsonDeserializer {
    private val objectMapper = ObjectMapper()

    fun <T> deserializeList(output: String, clazz: Class<T>): List<T> {
        return objectMapper.readValue(output, objectMapper.typeFactory.constructCollectionType(List::class.java, clazz))
    }
}