package cn.ckz.luqu.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * Created by CKZ on 2017/8/19.
 */

public class BSDataListBean implements Serializable {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BSDataListBean listBean = (BSDataListBean) o;

        return getId() != null ? getId().equals(listBean.getId()) : listBean.getId() == null;

    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }



    private int status;
    private String comment;
    private String bookmark;
    private String text;
    private ImageBean image;
    private String up;
    private String share_url;
    private int down;
    private int forward;
    private UBean u;
    private ShareInfoBean share_info;
    private String passtime;
    private String type;
    private String id;
    private VideoBean video;
    private GifBean gif;
    private HtmlBean html;
    private RepostBean repost;
    private List<TagsBean> tags;
    private List<TopCommentsBean> top_comments;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBookmark() {
        return bookmark;
    }

    public void setBookmark(String bookmark) {
        this.bookmark = bookmark;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ImageBean getImage() {
        return image;
    }

    public void setImage(ImageBean image) {
        this.image = image;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getForward() {
        return forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }

    public UBean getU() {
        return u;
    }

    public void setU(UBean u) {
        this.u = u;
    }
    public ShareInfoBean getShare_info() {
        return share_info;
    }

    public void setShare_info(ShareInfoBean share_info) {
        this.share_info = share_info;
    }

    public String getPasstime() {
        return passtime;
    }

    public void setPasstime(String passtime) {
        this.passtime = passtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VideoBean getVideo() {
        return video;
    }

    public void setVideo(VideoBean video) {
        this.video = video;
    }

    public GifBean getGif() {
        return gif;
    }

    public void setGif(GifBean gif) {
        this.gif = gif;
    }

    public HtmlBean getHtml() {
        return html;
    }

    public void setHtml(HtmlBean html) {
        this.html = html;
    }
    public RepostBean getRepost() {
        return repost;
    }

    public void setRepost(RepostBean repost) {
        this.repost = repost;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public List<TopCommentsBean> getTop_comments() {
        return top_comments;
    }

    public void setTop_comments(List<TopCommentsBean> top_comments) {
        this.top_comments = top_comments;
    }

    public static class ImageBean implements Serializable{
        /**
         * medium : []
         * big : ["http://wimg.spriteapp.cn/ugc/2017/02/08/589a7a1f525c3_1.jpg","http://dimg.spriteapp.cn/ugc/2017/02/08/589a7a1f525c3_1.jpg"]
         * download_url : ["http://wimg.spriteapp.cn/ugc/2017/02/08/589a7a1f525c3_d.jpg","http://dimg.spriteapp.cn/ugc/2017/02/08/589a7a1f525c3_d.jpg","http://wimg.spriteapp.cn/ugc/2017/02/08/589a7a1f525c3.jpg","http://dimg.spriteapp.cn/ugc/2017/02/08/589a7a1f525c3.jpg"]
         * height : 13016
         * width : 750
         * small : []
         * thumbnail_small : ["http://wimg.spriteapp.cn/crop/150x150/ugc/2017/02/08/589a7a1f525c3.jpg","http://dimg.spriteapp.cn/crop/150x150/ugc/2017/02/08/589a7a1f525c3.jpg"]
         */

        private int height;
        private int width;
        private List<?> medium;
        private List<String> big;
        private List<String> download_url;
        private List<?> small;
        private List<String> thumbnail_small;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public List<?> getMedium() {
            return medium;
        }

        public void setMedium(List<?> medium) {
            this.medium = medium;
        }

        public List<String> getBig() {
            return big;
        }

        public void setBig(List<String> big) {
            this.big = big;
        }

        public List<String> getDownload_url() {
            return download_url;
        }

        public void setDownload_url(List<String> download_url) {
            this.download_url = download_url;
        }

        public List<?> getSmall() {
            return small;
        }

        public void setSmall(List<?> small) {
            this.small = small;
        }

        public List<String> getThumbnail_small() {
            return thumbnail_small;
        }

        public void setThumbnail_small(List<String> thumbnail_small) {
            this.thumbnail_small = thumbnail_small;
        }
    }

    public static class UBean implements Serializable{
        /**
         * header : ["http://wimg.spriteapp.cn/profile/large/2016/08/18/57b54352ded37_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/08/18/57b54352ded37_mini.jpg"]
         * uid : 19135834
         * is_vip : false
         * is_v : false
         * room_url :
         * room_name : 哈哈哈
         * room_role : 帮主
         * room_icon : http://wimg.spriteapp.cn/ugc/2016/1101/gang_level_4.png
         * name : 公子小白V蓝胖纸 [哈哈哈]
         */

        private String uid;
        private boolean is_vip;
        private boolean is_v;
        private String room_url;
        private String room_name;
        private String room_role;
        private String room_icon;
        private String name;
        private List<String> header;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public boolean isIs_vip() {
            return is_vip;
        }

        public void setIs_vip(boolean is_vip) {
            this.is_vip = is_vip;
        }

        public boolean isIs_v() {
            return is_v;
        }

        public void setIs_v(boolean is_v) {
            this.is_v = is_v;
        }

        public String getRoom_url() {
            return room_url;
        }

        public void setRoom_url(String room_url) {
            this.room_url = room_url;
        }

        public String getRoom_name() {
            return room_name;
        }

        public void setRoom_name(String room_name) {
            this.room_name = room_name;
        }

        public String getRoom_role() {
            return room_role;
        }

        public void setRoom_role(String room_role) {
            this.room_role = room_role;
        }

        public String getRoom_icon() {
            return room_icon;
        }

        public void setRoom_icon(String room_icon) {
            this.room_icon = room_icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getHeader() {
            return header;
        }

        public void setHeader(List<String> header) {
            this.header = header;
        }
    }

    public static class VideoBean implements Serializable{
        /**
         * playfcount : 8816
         * height : 640
         * width : 480
         * video : ["http://wvideo.spriteapp.cn/video/2017/0129/9bb6bb9c-e63b-11e6-84b2-90b11c479401_wpd.mp4","http://dvideo.spriteapp.cn/video/2017/0129/9bb6bb9c-e63b-11e6-84b2-90b11c479401_wpd.mp4"]
         * download : ["http://wvideo.spriteapp.cn/video/2017/0129/9bb6bb9c-e63b-11e6-84b2-90b11c479401_wpd.mp4","http://dvideo.spriteapp.cn/video/2017/0129/9bb6bb9c-e63b-11e6-84b2-90b11c479401_wpd.mp4"]
         * duration : 17
         * playcount : 49204
         * thumbnail : ["http://wimg.spriteapp.cn/picture/2017/0129/9bb6bb9c-e63b-11e6-84b2-90b11c479401_wpd.jpg","http://dimg.spriteapp.cn/picture/2017/0129/9bb6bb9c-e63b-11e6-84b2-90b11c479401_wpd.jpg"]
         * thumbnail_small : ["http://wimg.spriteapp.cn/crop/150x150/picture/2017/0129/9bb6bb9c-e63b-11e6-84b2-90b11c479401_wpd.jpg","http://dimg.spriteapp.cn/crop/150x150/picture/2017/0129/9bb6bb9c-e63b-11e6-84b2-90b11c479401_wpd.jpg"]
         */

        private int playfcount;
        private int height;
        private int width;
        private int duration;
        private int playcount;
        private List<String> video;
        private List<String> download;
        private List<String> thumbnail;
        private List<String> thumbnail_small;

        public int getPlayfcount() {
            return playfcount;
        }

        public void setPlayfcount(int playfcount) {
            this.playfcount = playfcount;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getPlaycount() {
            return playcount;
        }

        public void setPlaycount(int playcount) {
            this.playcount = playcount;
        }

        public List<String> getVideo() {
            return video;
        }

        public void setVideo(List<String> video) {
            this.video = video;
        }

        public List<String> getDownload() {
            return download;
        }

        public void setDownload(List<String> download) {
            this.download = download;
        }

        public List<String> getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(List<String> thumbnail) {
            this.thumbnail = thumbnail;
        }

        public List<String> getThumbnail_small() {
            return thumbnail_small;
        }

        public void setThumbnail_small(List<String> thumbnail_small) {
            this.thumbnail_small = thumbnail_small;
        }
    }

    public static class GifBean implements Serializable{
        /**
         * images : ["http://wimg.spriteapp.cn/ugc/2017/02/08/589a99e296feb.gif","http://dimg.spriteapp.cn/ugc/2017/02/08/589a99e296feb.gif"]
         * width : 240
         * gif_thumbnail : ["http://wimg.spriteapp.cn/ugc/2017/02/08/589a99e296feb_a_1.jpg","http://dimg.spriteapp.cn/ugc/2017/02/08/589a99e296feb_a_1.jpg"]
         * download_url : ["http://wimg.spriteapp.cn/ugc/2017/02/08/589a99e296feb_d.jpg","http://dimg.spriteapp.cn/ugc/2017/02/08/589a99e296feb_d.jpg","http://wimg.spriteapp.cn/ugc/2017/02/08/589a99e296feb_a_1.jpg","http://dimg.spriteapp.cn/ugc/2017/02/08/589a99e296feb_a_1.jpg"]
         * height : 156
         */

        private int width;
        private int height;
        private List<String> images;
        private List<String> gif_thumbnail;
        private List<String> download_url;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public List<String> getGif_thumbnail() {
            return gif_thumbnail;
        }

        public void setGif_thumbnail(List<String> gif_thumbnail) {
            this.gif_thumbnail = gif_thumbnail;
        }

        public List<String> getDownload_url() {
            return download_url;
        }

        public void setDownload_url(List<String> download_url) {
            this.download_url = download_url;
        }
    }
    public static class HtmlBean implements Serializable {
        /**
         * body :
         * title : 你到多少岁还是个宝宝？ (13)
         * thumbnail_small : ["http://wimg.spriteapp.cn/crop/150x150/capture/random/img/20170219222057_3522.jpg","http://dimg.spriteapp.cn/crop/150x150/capture/random/img/20170219222057_3522.jpg"]
         * source_url : http://ilikeqz.cc/quiz/load/1476060/?&rd=1&pid=23752386
         * desc : 你到多少岁还是个宝宝？
         * type : 1
         * thumbnail : ["http://wimg.spriteapp.cn/capture/random/img/20170219222057_3522.jpg","http://dimg.spriteapp.cn/capture/random/img/20170219222057_3522.jpg"]
         * view : {"playcount":0,"playfcount":13}
         */

        private String body;
        private String title;
        private String source_url;
        private String desc;
        private int type;
        private ViewBean view;
        private List<String> thumbnail_small;
        private List<String> thumbnail;

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSource_url() {
            return source_url;
        }

        public void setSource_url(String source_url) {
            this.source_url = source_url;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public ViewBean getView() {
            return view;
        }

        public void setView(ViewBean view) {
            this.view = view;
        }

        public List<String> getThumbnail_small() {
            return thumbnail_small;
        }

        public void setThumbnail_small(List<String> thumbnail_small) {
            this.thumbnail_small = thumbnail_small;
        }

        public List<String> getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(List<String> thumbnail) {
            this.thumbnail = thumbnail;
        }

        public static class ViewBean implements Serializable {
            /**
             * playcount : 0
             * playfcount : 13
             */

            private int playcount;
            private int playfcount;

            public int getPlaycount() {
                return playcount;
            }

            public void setPlaycount(int playcount) {
                this.playcount = playcount;
            }

            public int getPlayfcount() {
                return playfcount;
            }

            public void setPlayfcount(int playfcount) {
                this.playfcount = playfcount;
            }
        }
    }

    public static class RepostBean implements Serializable{

        private int status;
        private String comment;
        private String bookmark;
        private String text;
        private ImageBeanXI image;
        private VideoBeanXI video;
        private GifBeanXI gif;
        private String up;
        private String share_url;
        private int down;
        private int forward;
        private UBeanX u;
        private String passtime;
        private String type;
        private String id;
        private List<TopCommentsBean> top_comments;
        private List<TagsBean> tags;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getBookmark() {
            return bookmark;
        }

        public void setBookmark(String bookmark) {
            this.bookmark = bookmark;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public ImageBeanXI getImage() {
            return image;
        }


        public void setImage(ImageBeanXI image) {
            this.image = image;
        }
        public void setGif(GifBeanXI gif) {
            this.gif = gif;
        }
        public GifBeanXI getGif() {
            return gif;
        }
        public void setVideo(VideoBeanXI video) {
            this.video = video;
        }
        public VideoBeanXI getVideo() {
            return video;
        }
        public String getUp() {
            return up;
        }

        public void setUp(String up) {
            this.up = up;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public int getDown() {
            return down;
        }

        public void setDown(int down) {
            this.down = down;
        }

        public int getForward() {
            return forward;
        }

        public void setForward(int forward) {
            this.forward = forward;
        }

        public UBeanX getU() {
            return u;
        }

        public void setU(UBeanX u) {
            this.u = u;
        }

        public String getPasstime() {
            return passtime;
        }

        public void setPasstime(String passtime) {
            this.passtime = passtime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<TopCommentsBean> getTop_comments() {
            return top_comments;
        }

        public void setTop_comments(List<TopCommentsBean> top_comments) {
            this.top_comments = top_comments;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }
        public static class GifBeanXI implements Serializable {

            private int width;
            private int height;
            private List<String> images;
            private List<String> gif_thumbnail;
            private List<String> download_url;

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }

            public List<String> getGif_thumbnail() {
                return gif_thumbnail;
            }

            public void setGif_thumbnail(List<String> gif_thumbnail) {
                this.gif_thumbnail = gif_thumbnail;
            }

            public List<String> getDownload_url() {
                return download_url;
            }

            public void setDownload_url(List<String> download_url) {
                this.download_url = download_url;
            }
        }

        public static class VideoBeanXI implements Serializable{
            /**
             * playfcount : 30585
             * height : 480
             * width : 856
             * video : ["http://wvideo.spriteapp.cn/video/2016/0130/56ac1b13bcfd3_wpd.mp4","http://dvideo.spriteapp.cn/video/2016/0130/56ac1b13bcfd3_wpd.mp4"]
             * download : ["http://wvideo.spriteapp.cn/video/2016/0130/56ac1b13bcfd3_wpc.mp4","http://dvideo.spriteapp.cn/video/2016/0130/56ac1b13bcfd3_wpc.mp4"]
             * duration : 298
             * playcount : 121072
             * thumbnail : ["http://wimg.spriteapp.cn/picture/2016/0130/56ac1b13bcfd3_wpd.jpg","http://dimg.spriteapp.cn/picture/2016/0130/56ac1b13bcfd3_wpd.jpg"]
             * thumbnail_small : ["http://wimg.spriteapp.cn/crop/150x150/picture/2016/0130/56ac1b13bcfd3_wpd.jpg","http://dimg.spriteapp.cn/crop/150x150/picture/2016/0130/56ac1b13bcfd3_wpd.jpg"]
             */

            private int playfcount;
            private int height;
            private int width;
            private int duration;
            private int playcount;
            private List<String> video;
            private List<String> download;
            private List<String> thumbnail;
            private List<String> thumbnail_small;

            public int getPlayfcount() {
                return playfcount;
            }

            public void setPlayfcount(int playfcount) {
                this.playfcount = playfcount;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public int getPlaycount() {
                return playcount;
            }

            public void setPlaycount(int playcount) {
                this.playcount = playcount;
            }

            public List<String> getVideo() {
                return video;
            }

            public void setVideo(List<String> video) {
                this.video = video;
            }

            public List<String> getDownload() {
                return download;
            }

            public void setDownload(List<String> download) {
                this.download = download;
            }

            public List<String> getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(List<String> thumbnail) {
                this.thumbnail = thumbnail;
            }

            public List<String> getThumbnail_small() {
                return thumbnail_small;
            }

            public void setThumbnail_small(List<String> thumbnail_small) {
                this.thumbnail_small = thumbnail_small;
            }
        }
        public static class ImageBeanXI implements Serializable {
            /**
             * medium : []
             * big : ["http://wimg.spriteapp.cn/ugc/2017/03/11/58c3dca7a1604_1.jpg","http://dimg.spriteapp.cn/ugc/2017/03/11/58c3dca7a1604_1.jpg"]
             * download_url : ["http://wimg.spriteapp.cn/ugc/2017/03/11/58c3dca7a1604_d.jpg","http://dimg.spriteapp.cn/ugc/2017/03/11/58c3dca7a1604_d.jpg","http://wimg.spriteapp.cn/ugc/2017/03/11/58c3dca7a1604.jpg","http://dimg.spriteapp.cn/ugc/2017/03/11/58c3dca7a1604.jpg"]
             * height : 2225
             * width : 750
             * small : []
             * thumbnail_small : ["http://wimg.spriteapp.cn/crop/150x150/ugc/2017/03/11/58c3dca7a1604.jpg","http://dimg.spriteapp.cn/crop/150x150/ugc/2017/03/11/58c3dca7a1604.jpg"]
             */

            private int height;
            private int width;
            private List<?> medium;
            private List<String> big;
            private List<String> download_url;
            private List<?> small;
            private List<String> thumbnail_small;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public List<?> getMedium() {
                return medium;
            }

            public void setMedium(List<?> medium) {
                this.medium = medium;
            }

            public List<String> getBig() {
                return big;
            }

            public void setBig(List<String> big) {
                this.big = big;
            }

            public List<String> getDownload_url() {
                return download_url;
            }

            public void setDownload_url(List<String> download_url) {
                this.download_url = download_url;
            }

            public List<?> getSmall() {
                return small;
            }

            public void setSmall(List<?> small) {
                this.small = small;
            }

            public List<String> getThumbnail_small() {
                return thumbnail_small;
            }

            public void setThumbnail_small(List<String> thumbnail_small) {
                this.thumbnail_small = thumbnail_small;
            }
        }

        public static class UBeanX implements Serializable{
            /**
             * header : ["http://wimg.spriteapp.cn/profile/large/2016/07/26/57974925b34a6_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/07/26/57974925b34a6_mini.jpg"]
             * uid : 5348609
             * is_vip : false
             * is_v : true
             * room_url :
             * room_name : BS嫖基金
             * room_role : 帮主
             * room_icon : http://wimg.spriteapp.cn/ugc/2016/1101/gang_level_17.png
             * name : 我有了一个男朋友 [BS嫖基金]
             */

            private String uid;
            private boolean is_vip;
            private boolean is_v;
            private String room_url;
            private String room_name;
            private String room_role;
            private String room_icon;
            private String name;
            private List<String> header;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public boolean isIs_vip() {
                return is_vip;
            }

            public void setIs_vip(boolean is_vip) {
                this.is_vip = is_vip;
            }

            public boolean isIs_v() {
                return is_v;
            }

            public void setIs_v(boolean is_v) {
                this.is_v = is_v;
            }

            public String getRoom_url() {
                return room_url;
            }

            public void setRoom_url(String room_url) {
                this.room_url = room_url;
            }

            public String getRoom_name() {
                return room_name;
            }

            public void setRoom_name(String room_name) {
                this.room_name = room_name;
            }

            public String getRoom_role() {
                return room_role;
            }

            public void setRoom_role(String room_role) {
                this.room_role = room_role;
            }

            public String getRoom_icon() {
                return room_icon;
            }

            public void setRoom_icon(String room_icon) {
                this.room_icon = room_icon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<String> getHeader() {
                return header;
            }

            public void setHeader(List<String> header) {
                this.header = header;
            }
        }

        public static class TopCommentsBean implements Serializable{
            /**
             * voicetime : 0
             * status : 0
             * hate_count : 0
             * cmt_type : text
             * precid : 0
             * content : 看老师这表情，，，这位兄弟不妙啊
             * like_count : 78
             * u : {"header":["http://qzapp.qlogo.cn/qzapp/100336987/D0DD820C2EF573F0599AA92CAE6C7192/100","http://qzapp.qlogo.cn/qzapp/100336987/D0DD820C2EF573F0599AA92CAE6C7192/100"],"uid":"11422768","is_vip":false,"room_url":"","sex":"m","room_name":"","room_role":"","room_icon":"","name":"何必作践自己"}
             * preuid : 0
             * passtime : 2017-03-11 19:59:10
             * voiceuri :
             * id : 76105502
             */

            private int voicetime;
            private int status;
            private int hate_count;
            private String cmt_type;
            private int precid;
            private String content;
            private int like_count;
            private UBeanXX u;
            private int preuid;
            private String passtime;
            private String voiceuri;
            private int id;

            public int getVoicetime() {
                return voicetime;
            }

            public void setVoicetime(int voicetime) {
                this.voicetime = voicetime;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getHate_count() {
                return hate_count;
            }

            public void setHate_count(int hate_count) {
                this.hate_count = hate_count;
            }

            public String getCmt_type() {
                return cmt_type;
            }

            public void setCmt_type(String cmt_type) {
                this.cmt_type = cmt_type;
            }

            public int getPrecid() {
                return precid;
            }

            public void setPrecid(int precid) {
                this.precid = precid;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
            }

            public UBeanXX getU() {
                return u;
            }

            public void setU(UBeanXX u) {
                this.u = u;
            }

            public int getPreuid() {
                return preuid;
            }

            public void setPreuid(int preuid) {
                this.preuid = preuid;
            }

            public String getPasstime() {
                return passtime;
            }

            public void setPasstime(String passtime) {
                this.passtime = passtime;
            }

            public String getVoiceuri() {
                return voiceuri;
            }

            public void setVoiceuri(String voiceuri) {
                this.voiceuri = voiceuri;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public static class UBeanXX implements Serializable{
                /**
                 * header : ["http://qzapp.qlogo.cn/qzapp/100336987/D0DD820C2EF573F0599AA92CAE6C7192/100","http://qzapp.qlogo.cn/qzapp/100336987/D0DD820C2EF573F0599AA92CAE6C7192/100"]
                 * uid : 11422768
                 * is_vip : false
                 * room_url :
                 * sex : m
                 * room_name :
                 * room_role :
                 * room_icon :
                 * name : 何必作践自己
                 */

                private String uid;
                private boolean is_vip;
                private String room_url;
                private String sex;
                private String room_name;
                private String room_role;
                private String room_icon;
                private String name;
                private List<String> header;

                public String getUid() {
                    return uid;
                }

                public void setUid(String uid) {
                    this.uid = uid;
                }

                public boolean isIs_vip() {
                    return is_vip;
                }

                public void setIs_vip(boolean is_vip) {
                    this.is_vip = is_vip;
                }

                public String getRoom_url() {
                    return room_url;
                }

                public void setRoom_url(String room_url) {
                    this.room_url = room_url;
                }

                public String getSex() {
                    return sex;
                }

                public void setSex(String sex) {
                    this.sex = sex;
                }

                public String getRoom_name() {
                    return room_name;
                }

                public void setRoom_name(String room_name) {
                    this.room_name = room_name;
                }

                public String getRoom_role() {
                    return room_role;
                }

                public void setRoom_role(String room_role) {
                    this.room_role = room_role;
                }

                public String getRoom_icon() {
                    return room_icon;
                }

                public void setRoom_icon(String room_icon) {
                    this.room_icon = room_icon;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public List<String> getHeader() {
                    return header;
                }

                public void setHeader(List<String> header) {
                    this.header = header;
                }
            }
        }

        public static class TagsBean implements Serializable{
            /**
             * id : 1
             * name : 搞笑
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
    public static class TagsBean implements Serializable{
        /**
         * id : 60
         * name : 吐槽
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static class ShareInfoBean implements Serializable{
        /**
         * uid : 18386511
         * share_time : 2017-03-01 17:04:46
         * name : 用户197706
         */

        private int uid;
        private String share_time;
        private String name;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getShare_time() {
            return share_time;
        }

        public void setShare_time(String share_time) {
            this.share_time = share_time;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static class TopCommentsBean implements Serializable{
        /**
         * voicetime : 0
         * status : 0
         * hate_count : 0
         * cmt_type : text
         * precid : 0
         * content : 这男的不知好歹！还躲！
         * like_count : 19
         * u : {"header":["http://wimg.spriteapp.cn/profile/large/2017/01/05/586dfc9317e0c_mini.jpg","http://dimg.spriteapp.cn/profile/large/2017/01/05/586dfc9317e0c_mini.jpg"],"uid":"6844826","is_vip":false,"room_url":"","sex":"m","room_name":"","room_role":"","room_icon":"","name":"密斯茶v"}
         * preuid : 0
         * passtime : 2017-02-08 14:05:24
         * voiceuri :
         * id : 74148417
         * audio : {"duration":7,"audio":["http://wvoice.spriteapp.cn/voice/2017/0208/823945e4-edd0-11e6-9874-d4ae5296039d.mp3"]}
         */

        private int voicetime;
        private int status;
        private int hate_count;
        private String cmt_type;
        private int precid;
        private String content;
        private int like_count;
        private UBeanX u;
        private int preuid;
        private String passtime;
        private String voiceuri;
        private int id;
        private AudioBean audio;

        public int getVoicetime() {
            return voicetime;
        }

        public void setVoicetime(int voicetime) {
            this.voicetime = voicetime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getHate_count() {
            return hate_count;
        }

        public void setHate_count(int hate_count) {
            this.hate_count = hate_count;
        }

        public String getCmt_type() {
            return cmt_type;
        }

        public void setCmt_type(String cmt_type) {
            this.cmt_type = cmt_type;
        }

        public int getPrecid() {
            return precid;
        }

        public void setPrecid(int precid) {
            this.precid = precid;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public UBeanX getU() {
            return u;
        }

        public void setU(UBeanX u) {
            this.u = u;
        }

        public int getPreuid() {
            return preuid;
        }

        public void setPreuid(int preuid) {
            this.preuid = preuid;
        }

        public String getPasstime() {
            return passtime;
        }

        public void setPasstime(String passtime) {
            this.passtime = passtime;
        }

        public String getVoiceuri() {
            return voiceuri;
        }

        public void setVoiceuri(String voiceuri) {
            this.voiceuri = voiceuri;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public AudioBean getAudio() {
            return audio;
        }

        public void setAudio(AudioBean audio) {
            this.audio = audio;
        }

        public static class UBeanX implements Serializable{
            /**
             * header : ["http://wimg.spriteapp.cn/profile/large/2017/01/05/586dfc9317e0c_mini.jpg","http://dimg.spriteapp.cn/profile/large/2017/01/05/586dfc9317e0c_mini.jpg"]
             * uid : 6844826
             * is_vip : false
             * room_url :
             * sex : m
             * room_name :
             * room_role :
             * room_icon :
             * name : 密斯茶v
             */

            private String uid;
            private boolean is_vip;
            private String room_url;
            private String sex;
            private String room_name;
            private String room_role;
            private String room_icon;
            private String name;
            private List<String> header;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public boolean isIs_vip() {
                return is_vip;
            }

            public void setIs_vip(boolean is_vip) {
                this.is_vip = is_vip;
            }

            public String getRoom_url() {
                return room_url;
            }

            public void setRoom_url(String room_url) {
                this.room_url = room_url;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getRoom_name() {
                return room_name;
            }

            public void setRoom_name(String room_name) {
                this.room_name = room_name;
            }

            public String getRoom_role() {
                return room_role;
            }

            public void setRoom_role(String room_role) {
                this.room_role = room_role;
            }

            public String getRoom_icon() {
                return room_icon;
            }

            public void setRoom_icon(String room_icon) {
                this.room_icon = room_icon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<String> getHeader() {
                return header;
            }

            public void setHeader(List<String> header) {
                this.header = header;
            }
        }

        public static class AudioBean implements Serializable{
            /**
             * duration : 7
             * audio : ["http://wvoice.spriteapp.cn/voice/2017/0208/823945e4-edd0-11e6-9874-d4ae5296039d.mp3"]
             */

            private int duration;
            private List<String> audio;

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public List<String> getAudio() {
                return audio;
            }

            public void setAudio(List<String> audio) {
                this.audio = audio;
            }
        }
    }
}

