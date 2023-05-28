import request from '@/utils/request'

// 查询云文件管理列表
export function listCloud_file(query) {
  return request({
    url: '/im/cloud_file/list',
    method: 'get',
    params: query
  })
}

// 查询云文件管理详细
export function getCloud_file(id) {
  return request({
    url: '/im/cloud_file/' + id,
    method: 'get'
  })
}

// 新增云文件管理
export function addCloud_file(data) {
  return request({
    url: '/im/cloud_file',
    method: 'post',
    data: data
  })
}

// 修改云文件管理
export function updateCloud_file(data) {
  return request({
    url: '/im/cloud_file',
    method: 'put',
    data: data
  })
}

// 删除云文件管理
export function delCloud_file(id) {
  return request({
    url: '/im/cloud_file/' + id,
    method: 'delete'
  })
}
