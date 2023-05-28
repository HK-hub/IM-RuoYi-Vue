import request from '@/utils/request'

// 查询群聊申请列表
export function listApply(query) {
  return request({
    url: '/group/apply/list',
    method: 'get',
    params: query
  })
}

// 查询群聊申请详细
export function getApply(id) {
  return request({
    url: '/group/apply/' + id,
    method: 'get'
  })
}

// 新增群聊申请
export function addApply(data) {
  return request({
    url: '/group/apply',
    method: 'post',
    data: data
  })
}

// 修改群聊申请
export function updateApply(data) {
  return request({
    url: '/group/apply',
    method: 'put',
    data: data
  })
}

// 删除群聊申请
export function delApply(id) {
  return request({
    url: '/group/apply/' + id,
    method: 'delete'
  })
}
