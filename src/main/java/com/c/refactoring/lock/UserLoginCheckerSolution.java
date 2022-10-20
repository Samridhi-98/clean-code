package com.c.refactoring.lock;

import java.util.Date;
import java.util.List;

public class UserLoginCheckerSolution {

    private final long MAXIMUM_LOCK_PERIOD_IN_MS = 60 * 60 * 1000;

    /**
     * {@inheritDoc}.
     */
    public Lock isUserAllowedToLogin(long id, String status, boolean firstScreen, User userTryingToLogin, List existingLocks) {

        if(existingLocks.size() == 0 || existingLocks.get(0) == null){
            return createWriteLock();
        }

        Object[] object = (Object[]) existingLocks.get(0);
        String userId = (String) object[0];
        Date lockTimestamp = (Date) object[1];

        if(userId == null){
            return createWriteLock();
        }

        if (userId.equalsIgnoreCase(userTryingToLogin.getUserId())) {
            return createWriteLock();
        }

        long elapsedTimeSinceLock = new Date().getTime() - lockTimestamp.getTime();

        if (elapsedTimeSinceLock > MAXIMUM_LOCK_PERIOD_IN_MS && firstScreen ) {
            return createWriteLock();
        }

        return createReadLockWithMessage(userId);
    }

    private Lock createReadLockWithMessage(String userId) {
        Lock lock = new Lock();
        String lockMsg = Constants.LOCK_TEXT.replaceAll("@@USER@@", userId);
        lock.setRead(true);
        lock.setLockReason(lockMsg);
        return lock;
    }

    private Lock createWriteLock() {
        Lock lock = new Lock();
        lock.setRead(false);
        return lock;
    }
}
