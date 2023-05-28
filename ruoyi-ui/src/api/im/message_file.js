import request from '@/utils/request'

// 查询文件消息列表
export function listMessage_file(query) {
  return request({
    url: '/im/message_file/list',
    method: 'get',
    params: query
  })
}

// 查询文件消息详细
export function getMessage_file(id) {
  return request({
    url: '/im/message_file/' + id,
    method: 'get'
  })
}

// 新增文件消息
export function addMessage_file(data) {
  return request({
    url: '/im/message_file',
    method: 'post',
    data: data
  })
}

// 修改文件消息
export function updateMessage_file(data) {
  return request({
    url: '/im/message_file',
    method: 'put',
    data: data
  })
}

// 删除文件消息
export function delMessage_file(id) {
  return request({
    url: '/im/message_file/' + id,
    method: 'delete'
  })
}
