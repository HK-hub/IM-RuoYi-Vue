import request from '@/utils/request'

// 查询群聊管理列表
export function listGroup(query) {
  return request({
    url: '/im/group/list',
    method: 'get',
    params: query
  })
}

// 查询群聊管理详细
export function getGroup(id) {
  return request({
    url: '/im/group/' + id,
    method: 'get'
  })
}

// 新增群聊管理
export function addGroup(data) {
  return request({
    url: '/im/group',
    method: 'post',
    data: data
  })
}

// 修改群聊管理
export function updateGroup(data) {
  return request({
    url: '/im/group',
    method: 'put',
    data: data
  })
}

// 删除群聊管理
export function delGroup(id) {
  return request({
    url: '/im/group/' + id,
    method: 'delete'
  })
}
