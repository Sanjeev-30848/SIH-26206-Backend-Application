package com.klef.sih.dto;

public class DashboardResponse
{

    private long totalUsers;
    private long totalSosRequests;
    private long pendingEmergencies;
    private long activeAlerts;
    private long availableShelters;
    private long totalDisasters;

    public DashboardResponse() {
    }

    public DashboardResponse(
            long totalUsers,
            long totalSosRequests,
            long pendingEmergencies,
            long activeAlerts,
            long availableShelters,
            long totalDisasters) {

        this.totalUsers = totalUsers;
        this.totalSosRequests = totalSosRequests;
        this.pendingEmergencies = pendingEmergencies;
        this.activeAlerts = activeAlerts;
        this.availableShelters = availableShelters;
        this.totalDisasters = totalDisasters;
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public long getTotalSosRequests() {
        return totalSosRequests;
    }

    public long getPendingEmergencies() {
        return pendingEmergencies;
    }

    public long getActiveAlerts() {
        return activeAlerts;
    }

    public long getAvailableShelters() {
        return availableShelters;
    }

    public long getTotalDisasters() {
        return totalDisasters;
    }
}