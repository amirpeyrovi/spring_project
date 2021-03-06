package org.j2os.monitor.modules.alarm.model.entity;

import org.j2os.monitor.modules.device.model.entity.DeviceProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "alarm_note")
public class AlarmNote {
    @Id
    @Column(name = "id", columnDefinition = "number")
    @SequenceGenerator(name = "alarm_note_seq", sequenceName = "alarm_note_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alarm_note_seq")
    private long id;

    @ManyToOne
    @JoinColumn(name = "device_property_id")
    private DeviceProperty deviceProperty;

    @Column(name = "name", columnDefinition = "nvarchar2(200)")
    private String name;

    @Column(name = "message", columnDefinition = "nvarchar2(500)")
    private String message;

    @Column(name = "creation_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "creation_by", updatable = false)
    private LocalDateTime createdBy;

    @Column(name = "updated_by")
    private LocalDateTime updatedBy;

    @PrePersist
    protected void onCreatedAt() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdatedAt() {
        updatedAt = LocalDateTime.now();
    }

    public AlarmNote() {
    }

    public AlarmNote(DeviceProperty deviceProperty, String name, String message) {
        this.deviceProperty = deviceProperty;
        this.name = name;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DeviceProperty getDeviceProperty() {
        return deviceProperty;
    }

    public void setDeviceProperty(DeviceProperty deviceProperty) {
        this.deviceProperty = deviceProperty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(LocalDateTime createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(LocalDateTime updatedBy) {
        this.updatedBy = updatedBy;
    }
}
