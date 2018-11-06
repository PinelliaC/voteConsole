package com.zzaki.model.entity;

import javax.persistence.*;

@Table(name = "project")
public class ProjectPO {
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "png_url")
    private String pngUrl;

    @Column(name = "QR_url")
    private String qrUrl;

    @Column(name = "vote_count")
    private Integer voteCount;

    @Column(name = "heat_value")
    private Integer heatValue;

    /**
     * @return project_id
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * @param projectId
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * @return project_name
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    /**
     * @return QR_url
     */
    public String getQrUrl() {
        return qrUrl;
    }

    /**
     * @param qrUrl
     */
    public void setQrUrl(String qrUrl) {
        this.qrUrl = qrUrl;
    }

    /**
     * @return vote_count
     */
    public Integer getVoteCount() {
        return voteCount;
    }

    /**
     * @param voteCount
     */
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    /**
     * @return heat_value
     */
    public Integer getHeatValue() {
        return heatValue;
    }

    /**
     * @param heatValue
     */
    public void setHeatValue(Integer heatValue) {
        this.heatValue = heatValue;
    }
}