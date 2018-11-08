package com.zzaki.model.entity;

import javax.persistence.*;

@Table(name = "main_page")
public class MainPagePO {
    @Column(name = "project_amount")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectAmount;

    @Column(name = "vote_amount")
    private Integer voteAmount;

    @Column(name = "view_amount")
    private Integer viewAmount;

    @Column(name = "png_url")
    private String pngUrl;

    /**
     * @return project_amount
     */
    public Integer getProjectAmount() {
        return projectAmount;
    }

    /**
     * @param projectAmount
     */
    public void setProjectAmount(Integer projectAmount) {
        this.projectAmount = projectAmount;
    }

    /**
     * @return vote_amount
     */
    public Integer getVoteAmount() {
        return voteAmount;
    }

    /**
     * @param voteAmount
     */
    public void setVoteAmount(Integer voteAmount) {
        this.voteAmount = voteAmount;
    }

    /**
     * @return view_amount
     */
    public Integer getViewAmount() {
        return viewAmount;
    }

    /**
     * @param viewAmount
     */
    public void setViewAmount(Integer viewAmount) {
        this.viewAmount = viewAmount;
    }

    /**
     * @return png_url
     */
    public String getPngUrl() {
        return pngUrl;
    }

    /**
     * @param pngUrl
     */
    public void setPngUrl(String pngUrl) {
        this.pngUrl = pngUrl;
    }
}