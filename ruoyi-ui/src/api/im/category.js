import request from '@/utils/request'

// 查询笔记分类列表
export function listCategory(query) {
  return request({
    url: '/im/category/list',
    method: 'get',
    params: query
  })
}

// 查询笔记分类详细
export function getCategory(id) {
  return request({
    url: '/im/category/' + id,
    method: 'get'
  })
}

// 新增笔记分类
export function addCategory(data) {
  return request({
    url: '/im/category',
    method: 'post',
    data: data
  })
}

// 修改笔记分类
export function updateCategory(data) {
  return request({
    url: '/im/category',
    method: 'put',
    data: data
  })
}

// 删除笔记分类
export function delCategory(id) {
  return request({
    url: '/im/category/' + id,
    method: 'delete'
  })
}
