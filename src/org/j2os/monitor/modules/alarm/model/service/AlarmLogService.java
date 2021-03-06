package org.j2os.monitor.modules.alarm.model.service;

import org.j2os.monitor.modules.alarm.model.entity.AlarmLog;
import org.j2os.monitor.modules.alarm.model.repository.AlarmLogRepository;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.j2os.monitor.modules.utils.MyBeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class AlarmLogService implements ServiceInterface<AlarmLog> {
    private AlarmLogRepository alarmLogRepository;

    @Autowired
    public AlarmLogService(AlarmLogRepository alarmLogRepository) {
        this.alarmLogRepository = alarmLogRepository;
    }

    @Override
    @Transactional
    public void add(AlarmLog alarmLog) {
        this.alarmLogRepository.save(alarmLog);
    }

    @Override
    @Transactional
    public void update(AlarmLog alarmLog) throws InvocationTargetException, IllegalAccessException {
        AlarmLog exist = this.alarmLogRepository.findOne(AlarmLog.class,alarmLog.getAlarmLogId());
        MyBeanCopy myBeanCopy = new MyBeanCopy();
        myBeanCopy.copyProperties(exist, alarmLog);
        this.alarmLogRepository.save(exist);
    }

    @Override
    public List<AlarmLog> findAll() {
        return this.alarmLogRepository.findAll(AlarmLog.class);
    }

    @Override
    @Transactional
    public void delete(AlarmLog alarmLog) {
        this.alarmLogRepository.delete(alarmLog);
    }

    @Override
    public AlarmLog findOne(AlarmLog alarmLog) {
        return this.alarmLogRepository.findOne(AlarmLog.class,alarmLog.getAlarmLogId());
    }

    @Override
    public Boolean existsById(long id) {
        return this.alarmLogRepository.existsById(AlarmLog.class,id);
    }

    @Override
    public AlarmLog findById(long id) {
        return this.alarmLogRepository.findOne(AlarmLog.class,id);

    }
}
