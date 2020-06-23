package com.wilson.serviceview

class QuickReplyEntity {
    var lastUpdateDate: Long = 0
    var replyGroups: ArrayList<ReplyGroup>? = null
    var replys: ArrayList<Reply>? = null
}

class ReplyGroup {
    var groupId: String? = null
    var groupMemo: String? = null
    var groupName: String? = null
    var ownerType: Int = 0
    var sortIndex: Long = 0
}

class Reply {
    var content: String? = null
    var groupId: String? = null
    var id: String? = null
    var isDeleted: Boolean = false
    var msgType: Int = 0
    var sortIndex: Long = 0
    var title: String? = null
}


//class  Group{
//    var replyGroup: ReplyGroup? = null
//    var replys: ArrayList<Reply> = ArrayList()
//
//
//
//class QuickReplyGroup {
//    var type: Int = 0
//    var group: ArrayList<Group> =  ArrayList()
//}