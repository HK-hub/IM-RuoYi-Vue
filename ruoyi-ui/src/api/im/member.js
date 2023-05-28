import request from '@/utils/request'

// 查询群员管理列表
export function listMember(query) {
  return request({
    url: '/im/member/list',
    method: 'get',
    params: query
  })
}

// 查询群员管理详细
export function getMember(id) {
  return request({
    url: '/im/member/' + id,
    method: 'get'
  })
}

// 新增群员管理
export function addMember(data) {
  return request({
    url: '/im/member',
    method: 'post',
    data: data
  })
}

// 修改群员管理
export function updateMember(data) {
  return request({
    url: '/im/member',
    method: 'put',
    data: data
  })
}

// 删除群员管理
export function delMember(id) {
  return request({
    url: '/im/member/' + id,
    method: 'delete'
  })
}
