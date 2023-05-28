import request from '@/utils/request'

// 查询笔记标签列表
export function listNote_tag(query) {
  return request({
    url: '/im/note_tag/list',
    method: 'get',
    params: query
  })
}

// 查询笔记标签详细
export function getNote_tag(id) {
  return request({
    url: '/im/note_tag/' + id,
    method: 'get'
  })
}

// 新增笔记标签
export function addNote_tag(data) {
  return request({
    url: '/im/note_tag',
    method: 'post',
    data: data
  })
}

// 修改笔记标签
export function updateNote_tag(data) {
  return request({
    url: '/im/note_tag',
    method: 'put',
    data: data
  })
}

// 删除笔记标签
export function delNote_tag(id) {
  return request({
    url: '/im/note_tag/' + id,
    method: 'delete'
  })
}
