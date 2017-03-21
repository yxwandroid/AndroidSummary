package willson.bean;

/**
 * @描述 ${cursor};
 * @Author willson  {  http://xiaowutongxue.com   }
 * @创建日期 ${date} ${time}
 */

public class TabTitle {

    private int COUNT = 5;
    private String titles;

    public TabTitle(int COUNT, String titles) {
        this.COUNT = COUNT;
        this.titles = titles;
    }

    public TabTitle(String titles) {
        this.titles = titles;
    }

    public int getCOUNT() {
        return COUNT;
    }

    public void setCOUNT(int COUNT) {
        this.COUNT = COUNT;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }
}
