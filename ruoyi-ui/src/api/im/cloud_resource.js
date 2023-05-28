import request from '@/utils/request'

// 查询云资源管理列表
export function listCloud_resource(query) {
  return request({
    url: '/im/cloud_resource/list',
    method: 'get',
    params: query
  })
}

// 查询云资源管理详细
export function getCloud_resource(id) {
  return request({
    url: '/im/cloud_resource/' + id,
    method: 'get'
  })
}

// 新增云资源管理
export function addCloud_resource(data) {
  return request({
    url: '/im/cloud_resource',
    method: 'post',
    data: data
  })
}

// 修改云资源管理
export function updateCloud_resource(data) {
  return request({
    url: '/im/cloud_resource',
    method: 'put',
    data: data
  })
}

// 删除云资源管理
export function delCloud_resource(id) {
  return request({
    url: '/im/cloud_resource/' + id,
    method: 'delete'
  })
}
