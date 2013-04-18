package models;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public final class Datastore {

  private static final BiMap<String, String> regIdsToUserIds = HashBiMap.create();
  private static final Logger logger =
      Logger.getLogger(Datastore.class.getName());

  private Datastore() {
    throw new UnsupportedOperationException();
  }

  /**
   * Registers a device.
   */
  public static void register(String regId, String userId) {
    logger.info("Registering " + regId);
    synchronized (regIdsToUserIds) {
        regIdsToUserIds.put(regId, userId);
    }
  }

  /**
   * Unregisters a device.
   */
  public static void unregister(String regId) {
    logger.info("Unregistering " + regId);
    synchronized (regIdsToUserIds) {
        regIdsToUserIds.remove(regId);
    }
  }

  /**
   * Updates the registration id of a device.
   */
  public static void updateRegistration(String oldId, String newId) {
    logger.info("Updating " + oldId + " to " + newId);
    synchronized (regIdsToUserIds) {
        String userId = regIdsToUserIds.get(oldId);
        regIdsToUserIds.remove(oldId);
        regIdsToUserIds.put(newId, userId);
    }
  }

  /**
   * Gets all registered devices.
   */
  public static List<String> getDevices() {
    synchronized (regIdsToUserIds) {
      return new ArrayList<String>(regIdsToUserIds.keySet());
    }
  }

    public static String getUserId(String regId) {
        synchronized (regIdsToUserIds) {
            return regIdsToUserIds.get(regId);
        }
    }

  public static String getRegId(String userId) {
      synchronized (regIdsToUserIds) {
          return regIdsToUserIds.inverse().get(userId);
      }
  }

}
