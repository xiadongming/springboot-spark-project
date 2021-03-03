package com.itchina.page;

/**
 * @Date: 2021/3/3 14:11
 * @Desc: 最好的myabtis分页工具
 *      ：逻辑分页（内存分页）：数据库返回的不是分页结果，而是全部数据，然后再由程序员通过代码获取分页数据
 *      ：物理分页：数据库返回的就是分页结果，而不是全部的结果
 *        Page page = new Page()的方法是物理分页
 *
 *        RowBounds ：逻辑分页
 *        PageHelper：物理分页，较好
 */
public class PageHelperUtils {
}
