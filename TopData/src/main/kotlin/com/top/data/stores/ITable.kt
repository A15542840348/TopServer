package com.top.data.stores

import com.top.data.models.common.Page
import com.top.data.models.common.Pageable

interface ITable<T> {
    /**
     * 保存新的数据
     */
    fun save(item: T): T

    /**
     * 保存所有新增数据
     */
    fun saveAll(items: List<T>): List<T>

    /**
     * 更新的数据
     */
    fun update(item: T): T

    /**
     * 更新所有数据
     */
    fun updateAll(items: List<T>): List<T>

    /**
     * 根据ID查找数据
     */
    fun findById(id: String): T?

    /**
     * 查找所有数据
     */
    fun findAll(pageable: Pageable): Page<T>

    /**
     * 根据ID集合，查找数据
     */
    fun findAllById(ids: List<String>): List<T>

    /**
     * 根据ID判断数据是否存在
     */
    fun existsById(id: String): Boolean

    /**
     * 返回数据总个数
     */
    fun count(): Long

    /**
     * 根据ID删除数据
     */
    fun deleteById(id: String)

    /**
     * 删除数据
     */
    fun delete(item: T)

    /**
     * 根据ID集合，删除所有指定数据
     */
    fun deleteAllById(ids: List<String>)
}