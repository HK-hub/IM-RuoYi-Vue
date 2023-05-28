import request from '@/utils/request'

// 查询消息流水列表
export function listFlow(query) {
  return request({
    url: '/im/flow/list',
    method: 'get',
    params: query
  })
}

// 查询消息流水详细
export function getFlow(id) {
  return request({
    url: '/im/flow/' + id,
    method: 'get'
  })
}

// 新增消息流水
export function addFlow(data) {
  return request({
    url: '/im/flow',
    method: 'post',
    data: data
  })
}

// 修改消息流水
export function updateFlow(data) {
  return request({
    url: '/im/flow',
    method: 'put',
    data: data
  })
}

// 删除消息流水
export function delFlow(id) {
  return request({
    url: '/im/flow/' + id,
    method: 'delete'
  })
}
