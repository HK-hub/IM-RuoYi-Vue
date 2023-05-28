import request from '@/utils/request'

// 查询笔记管理列表
export function listNote(query) {
  return request({
    url: '/im/note/list',
    method: 'get',
    params: query
  })
}

// 查询笔记管理详细
export function getNote(id) {
  return request({
    url: '/im/note/' + id,
    method: 'get'
  })
}

// 新增笔记管理
export function addNote(data) {
  return request({
    url: '/im/note',
    method: 'post',
    data: data
  })
}

// 修改笔记管理
export function updateNote(data) {
  return request({
    url: '/im/note',
    method: 'put',
    data: data
  })
}

// 删除笔记管理
export function delNote(id) {
  return request({
    url: '/im/note/' + id,
    method: 'delete'
  })
}
