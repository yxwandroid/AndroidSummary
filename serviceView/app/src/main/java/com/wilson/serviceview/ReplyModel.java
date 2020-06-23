package com.wilson.serviceview;

import java.util.List;

public class ReplyModel {
    private final String groupName;
    private final String id;
    private final int ownerType;
    private final int sortIndex;
    private final List<Replys> replys;
    private final List<ReplyModel> children;
    public ReplyModel(List<ReplyModel> children, String groupName, String id, int ownerType, List<Replys> replys, int sortIndex) {
        this.children = children;
        this.groupName = groupName;
        this.id = id;
        this.ownerType = ownerType;
        this.replys = replys;
        this.sortIndex = sortIndex;
    }

    public List<ReplyModel> getChildren() {
        return children;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getId() {
        return id;
    }

    public int getOwnerType() {
        return ownerType;
    }

    public List<Replys> getReplys() {
        return replys;
    }

    public int getSortIndex() {
        return sortIndex;
    }


}
 class Replys {
    private final String content;

    private final String createBy;

    private final long createDate;

    private final String groupId;

    private final String id;

    private final boolean isDeleted;

    private final int msgType;

    private final long sortIndex;

    private final String tenantId;

    private final String title;

    private final String updateBy;

    private final long updateDate;

    public Replys(String content, String createBy, long createDate, String groupId, String id,
                  boolean isDeleted, int msgType, long sortIndex, String tenantId, String title,
                  String updateBy, long updateDate) {
        this.content = content;
        this.createBy = createBy;
        this.createDate = createDate;
        this.groupId = groupId;
        this.id = id;
        this.isDeleted = isDeleted;
        this.msgType = msgType;
        this.sortIndex = sortIndex;
        this.tenantId = tenantId;
        this.title = title;
        this.updateBy = updateBy;
        this.updateDate = updateDate;
    }

    public String getContent() {
        return content;
    }

    public String getCreateBy() {
        return createBy;
    }

    public long getCreateDate() {
        return createDate;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getId() {
        return id;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public int getMsgType() {
        return msgType;
    }

    public long getSortIndex() {
        return sortIndex;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getTitle() {
        return title;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public long getUpdateDate() {
        return updateDate;
    }
}