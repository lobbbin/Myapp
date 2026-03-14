package com.ultimatelifesimulator.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.ultimatelifesimulator.data.local.dao.CharacterDao;
import com.ultimatelifesimulator.data.local.dao.CharacterDao_Impl;
import com.ultimatelifesimulator.data.local.dao.FactionDao;
import com.ultimatelifesimulator.data.local.dao.FactionDao_Impl;
import com.ultimatelifesimulator.data.local.dao.GameEventDao;
import com.ultimatelifesimulator.data.local.dao.GameEventDao_Impl;
import com.ultimatelifesimulator.data.local.dao.GameStateDao;
import com.ultimatelifesimulator.data.local.dao.GameStateDao_Impl;
import com.ultimatelifesimulator.data.local.dao.HealthRecordDao;
import com.ultimatelifesimulator.data.local.dao.HealthRecordDao_Impl;
import com.ultimatelifesimulator.data.local.dao.ItemDao;
import com.ultimatelifesimulator.data.local.dao.ItemDao_Impl;
import com.ultimatelifesimulator.data.local.dao.LocationDao;
import com.ultimatelifesimulator.data.local.dao.LocationDao_Impl;
import com.ultimatelifesimulator.data.local.dao.RelationshipDao;
import com.ultimatelifesimulator.data.local.dao.RelationshipDao_Impl;
import com.ultimatelifesimulator.data.local.dao.SkillDao;
import com.ultimatelifesimulator.data.local.dao.SkillDao_Impl;
import com.ultimatelifesimulator.data.local.dao.TraitDao;
import com.ultimatelifesimulator.data.local.dao.TraitDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class GameDatabase_Impl extends GameDatabase {
  private volatile CharacterDao _characterDao;

  private volatile TraitDao _traitDao;

  private volatile SkillDao _skillDao;

  private volatile LocationDao _locationDao;

  private volatile FactionDao _factionDao;

  private volatile RelationshipDao _relationshipDao;

  private volatile ItemDao _itemDao;

  private volatile GameEventDao _gameEventDao;

  private volatile HealthRecordDao _healthRecordDao;

  private volatile GameStateDao _gameStateDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `characters` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `age` INTEGER NOT NULL, `gender` TEXT NOT NULL, `birthDay` INTEGER NOT NULL, `birthMonth` INTEGER NOT NULL, `birthYear` INTEGER NOT NULL, `health` INTEGER NOT NULL, `energy` INTEGER NOT NULL, `stress` INTEGER NOT NULL, `charisma` INTEGER NOT NULL, `intellect` INTEGER NOT NULL, `cunning` INTEGER NOT NULL, `violence` INTEGER NOT NULL, `stealth` INTEGER NOT NULL, `perception` INTEGER NOT NULL, `willpower` INTEGER NOT NULL, `reputation` INTEGER NOT NULL, `wealth` REAL NOT NULL, `piety` INTEGER NOT NULL, `loyalty` INTEGER NOT NULL, `addiction` INTEGER NOT NULL, `heat` INTEGER NOT NULL, `education` INTEGER NOT NULL, `streetCred` INTEGER NOT NULL, `nobleStanding` INTEGER NOT NULL, `politicalCapital` INTEGER NOT NULL, `lifePath` TEXT NOT NULL, `currentLocationId` INTEGER NOT NULL, `gameYear` INTEGER NOT NULL, `gameDay` INTEGER NOT NULL, `gameMonth` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `traits` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, `isPositive` INTEGER NOT NULL, `isNegative` INTEGER NOT NULL, `statModifiers` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `skills` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `category` TEXT NOT NULL, `level` INTEGER NOT NULL, `xp` INTEGER NOT NULL, `characterId` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `locations` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `type` TEXT NOT NULL, `region` TEXT NOT NULL, `description` TEXT NOT NULL, `population` INTEGER NOT NULL, `securityLevel` INTEGER NOT NULL, `prosperity` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `factions` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `type` TEXT NOT NULL, `power` INTEGER NOT NULL, `opinionOfPlayer` INTEGER NOT NULL, `description` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `relationships` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `characterId` INTEGER NOT NULL, `targetCharacterId` INTEGER NOT NULL, `type` TEXT NOT NULL, `score` INTEGER NOT NULL, `trust` INTEGER NOT NULL, `fear` INTEGER NOT NULL, `respect` INTEGER NOT NULL, `loyalty` INTEGER NOT NULL, `debt` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `items` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `category` TEXT NOT NULL, `value` REAL NOT NULL, `weight` REAL NOT NULL, `quantity` INTEGER NOT NULL, `isEquipped` INTEGER NOT NULL, `condition` INTEGER NOT NULL, `characterId` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `game_events` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `description` TEXT NOT NULL, `category` TEXT NOT NULL, `choices` TEXT NOT NULL, `triggerConditions` TEXT NOT NULL, `isRandom` INTEGER NOT NULL, `weight` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `health_records` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `characterId` INTEGER NOT NULL, `type` TEXT NOT NULL, `severity` INTEGER NOT NULL, `isChronic` INTEGER NOT NULL, `isTreated` INTEGER NOT NULL, `notes` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `game_states` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `characterId` INTEGER NOT NULL, `savedAt` INTEGER NOT NULL, `gameYear` INTEGER NOT NULL, `gameMonth` INTEGER NOT NULL, `gameDay` INTEGER NOT NULL, `turnNumber` INTEGER NOT NULL, `isAutoSave` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e6344714017506aa48c9eae0de938e26')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `characters`");
        db.execSQL("DROP TABLE IF EXISTS `traits`");
        db.execSQL("DROP TABLE IF EXISTS `skills`");
        db.execSQL("DROP TABLE IF EXISTS `locations`");
        db.execSQL("DROP TABLE IF EXISTS `factions`");
        db.execSQL("DROP TABLE IF EXISTS `relationships`");
        db.execSQL("DROP TABLE IF EXISTS `items`");
        db.execSQL("DROP TABLE IF EXISTS `game_events`");
        db.execSQL("DROP TABLE IF EXISTS `health_records`");
        db.execSQL("DROP TABLE IF EXISTS `game_states`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsCharacters = new HashMap<String, TableInfo.Column>(32);
        _columnsCharacters.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("age", new TableInfo.Column("age", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("gender", new TableInfo.Column("gender", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("birthDay", new TableInfo.Column("birthDay", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("birthMonth", new TableInfo.Column("birthMonth", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("birthYear", new TableInfo.Column("birthYear", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("health", new TableInfo.Column("health", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("energy", new TableInfo.Column("energy", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("stress", new TableInfo.Column("stress", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("charisma", new TableInfo.Column("charisma", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("intellect", new TableInfo.Column("intellect", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("cunning", new TableInfo.Column("cunning", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("violence", new TableInfo.Column("violence", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("stealth", new TableInfo.Column("stealth", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("perception", new TableInfo.Column("perception", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("willpower", new TableInfo.Column("willpower", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("reputation", new TableInfo.Column("reputation", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("wealth", new TableInfo.Column("wealth", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("piety", new TableInfo.Column("piety", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("loyalty", new TableInfo.Column("loyalty", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("addiction", new TableInfo.Column("addiction", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("heat", new TableInfo.Column("heat", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("education", new TableInfo.Column("education", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("streetCred", new TableInfo.Column("streetCred", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("nobleStanding", new TableInfo.Column("nobleStanding", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("politicalCapital", new TableInfo.Column("politicalCapital", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("lifePath", new TableInfo.Column("lifePath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("currentLocationId", new TableInfo.Column("currentLocationId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("gameYear", new TableInfo.Column("gameYear", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("gameDay", new TableInfo.Column("gameDay", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCharacters.put("gameMonth", new TableInfo.Column("gameMonth", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCharacters = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCharacters = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCharacters = new TableInfo("characters", _columnsCharacters, _foreignKeysCharacters, _indicesCharacters);
        final TableInfo _existingCharacters = TableInfo.read(db, "characters");
        if (!_infoCharacters.equals(_existingCharacters)) {
          return new RoomOpenHelper.ValidationResult(false, "characters(com.ultimatelifesimulator.data.local.entity.CharacterEntity).\n"
                  + " Expected:\n" + _infoCharacters + "\n"
                  + " Found:\n" + _existingCharacters);
        }
        final HashMap<String, TableInfo.Column> _columnsTraits = new HashMap<String, TableInfo.Column>(6);
        _columnsTraits.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTraits.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTraits.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTraits.put("isPositive", new TableInfo.Column("isPositive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTraits.put("isNegative", new TableInfo.Column("isNegative", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTraits.put("statModifiers", new TableInfo.Column("statModifiers", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTraits = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTraits = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTraits = new TableInfo("traits", _columnsTraits, _foreignKeysTraits, _indicesTraits);
        final TableInfo _existingTraits = TableInfo.read(db, "traits");
        if (!_infoTraits.equals(_existingTraits)) {
          return new RoomOpenHelper.ValidationResult(false, "traits(com.ultimatelifesimulator.data.local.entity.TraitEntity).\n"
                  + " Expected:\n" + _infoTraits + "\n"
                  + " Found:\n" + _existingTraits);
        }
        final HashMap<String, TableInfo.Column> _columnsSkills = new HashMap<String, TableInfo.Column>(6);
        _columnsSkills.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSkills.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSkills.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSkills.put("level", new TableInfo.Column("level", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSkills.put("xp", new TableInfo.Column("xp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSkills.put("characterId", new TableInfo.Column("characterId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSkills = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSkills = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSkills = new TableInfo("skills", _columnsSkills, _foreignKeysSkills, _indicesSkills);
        final TableInfo _existingSkills = TableInfo.read(db, "skills");
        if (!_infoSkills.equals(_existingSkills)) {
          return new RoomOpenHelper.ValidationResult(false, "skills(com.ultimatelifesimulator.data.local.entity.SkillEntity).\n"
                  + " Expected:\n" + _infoSkills + "\n"
                  + " Found:\n" + _existingSkills);
        }
        final HashMap<String, TableInfo.Column> _columnsLocations = new HashMap<String, TableInfo.Column>(8);
        _columnsLocations.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("region", new TableInfo.Column("region", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("population", new TableInfo.Column("population", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("securityLevel", new TableInfo.Column("securityLevel", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocations.put("prosperity", new TableInfo.Column("prosperity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLocations = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLocations = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLocations = new TableInfo("locations", _columnsLocations, _foreignKeysLocations, _indicesLocations);
        final TableInfo _existingLocations = TableInfo.read(db, "locations");
        if (!_infoLocations.equals(_existingLocations)) {
          return new RoomOpenHelper.ValidationResult(false, "locations(com.ultimatelifesimulator.data.local.entity.LocationEntity).\n"
                  + " Expected:\n" + _infoLocations + "\n"
                  + " Found:\n" + _existingLocations);
        }
        final HashMap<String, TableInfo.Column> _columnsFactions = new HashMap<String, TableInfo.Column>(6);
        _columnsFactions.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFactions.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFactions.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFactions.put("power", new TableInfo.Column("power", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFactions.put("opinionOfPlayer", new TableInfo.Column("opinionOfPlayer", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFactions.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFactions = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFactions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFactions = new TableInfo("factions", _columnsFactions, _foreignKeysFactions, _indicesFactions);
        final TableInfo _existingFactions = TableInfo.read(db, "factions");
        if (!_infoFactions.equals(_existingFactions)) {
          return new RoomOpenHelper.ValidationResult(false, "factions(com.ultimatelifesimulator.data.local.entity.FactionEntity).\n"
                  + " Expected:\n" + _infoFactions + "\n"
                  + " Found:\n" + _existingFactions);
        }
        final HashMap<String, TableInfo.Column> _columnsRelationships = new HashMap<String, TableInfo.Column>(10);
        _columnsRelationships.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRelationships.put("characterId", new TableInfo.Column("characterId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRelationships.put("targetCharacterId", new TableInfo.Column("targetCharacterId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRelationships.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRelationships.put("score", new TableInfo.Column("score", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRelationships.put("trust", new TableInfo.Column("trust", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRelationships.put("fear", new TableInfo.Column("fear", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRelationships.put("respect", new TableInfo.Column("respect", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRelationships.put("loyalty", new TableInfo.Column("loyalty", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRelationships.put("debt", new TableInfo.Column("debt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRelationships = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRelationships = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRelationships = new TableInfo("relationships", _columnsRelationships, _foreignKeysRelationships, _indicesRelationships);
        final TableInfo _existingRelationships = TableInfo.read(db, "relationships");
        if (!_infoRelationships.equals(_existingRelationships)) {
          return new RoomOpenHelper.ValidationResult(false, "relationships(com.ultimatelifesimulator.data.local.entity.RelationshipEntity).\n"
                  + " Expected:\n" + _infoRelationships + "\n"
                  + " Found:\n" + _existingRelationships);
        }
        final HashMap<String, TableInfo.Column> _columnsItems = new HashMap<String, TableInfo.Column>(9);
        _columnsItems.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItems.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItems.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItems.put("value", new TableInfo.Column("value", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItems.put("weight", new TableInfo.Column("weight", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItems.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItems.put("isEquipped", new TableInfo.Column("isEquipped", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItems.put("condition", new TableInfo.Column("condition", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItems.put("characterId", new TableInfo.Column("characterId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItems = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesItems = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoItems = new TableInfo("items", _columnsItems, _foreignKeysItems, _indicesItems);
        final TableInfo _existingItems = TableInfo.read(db, "items");
        if (!_infoItems.equals(_existingItems)) {
          return new RoomOpenHelper.ValidationResult(false, "items(com.ultimatelifesimulator.data.local.entity.ItemEntity).\n"
                  + " Expected:\n" + _infoItems + "\n"
                  + " Found:\n" + _existingItems);
        }
        final HashMap<String, TableInfo.Column> _columnsGameEvents = new HashMap<String, TableInfo.Column>(8);
        _columnsGameEvents.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameEvents.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameEvents.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameEvents.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameEvents.put("choices", new TableInfo.Column("choices", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameEvents.put("triggerConditions", new TableInfo.Column("triggerConditions", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameEvents.put("isRandom", new TableInfo.Column("isRandom", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameEvents.put("weight", new TableInfo.Column("weight", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGameEvents = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGameEvents = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGameEvents = new TableInfo("game_events", _columnsGameEvents, _foreignKeysGameEvents, _indicesGameEvents);
        final TableInfo _existingGameEvents = TableInfo.read(db, "game_events");
        if (!_infoGameEvents.equals(_existingGameEvents)) {
          return new RoomOpenHelper.ValidationResult(false, "game_events(com.ultimatelifesimulator.data.local.entity.GameEventEntity).\n"
                  + " Expected:\n" + _infoGameEvents + "\n"
                  + " Found:\n" + _existingGameEvents);
        }
        final HashMap<String, TableInfo.Column> _columnsHealthRecords = new HashMap<String, TableInfo.Column>(7);
        _columnsHealthRecords.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHealthRecords.put("characterId", new TableInfo.Column("characterId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHealthRecords.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHealthRecords.put("severity", new TableInfo.Column("severity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHealthRecords.put("isChronic", new TableInfo.Column("isChronic", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHealthRecords.put("isTreated", new TableInfo.Column("isTreated", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHealthRecords.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHealthRecords = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHealthRecords = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHealthRecords = new TableInfo("health_records", _columnsHealthRecords, _foreignKeysHealthRecords, _indicesHealthRecords);
        final TableInfo _existingHealthRecords = TableInfo.read(db, "health_records");
        if (!_infoHealthRecords.equals(_existingHealthRecords)) {
          return new RoomOpenHelper.ValidationResult(false, "health_records(com.ultimatelifesimulator.data.local.entity.HealthRecordEntity).\n"
                  + " Expected:\n" + _infoHealthRecords + "\n"
                  + " Found:\n" + _existingHealthRecords);
        }
        final HashMap<String, TableInfo.Column> _columnsGameStates = new HashMap<String, TableInfo.Column>(8);
        _columnsGameStates.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameStates.put("characterId", new TableInfo.Column("characterId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameStates.put("savedAt", new TableInfo.Column("savedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameStates.put("gameYear", new TableInfo.Column("gameYear", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameStates.put("gameMonth", new TableInfo.Column("gameMonth", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameStates.put("gameDay", new TableInfo.Column("gameDay", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameStates.put("turnNumber", new TableInfo.Column("turnNumber", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameStates.put("isAutoSave", new TableInfo.Column("isAutoSave", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGameStates = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGameStates = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGameStates = new TableInfo("game_states", _columnsGameStates, _foreignKeysGameStates, _indicesGameStates);
        final TableInfo _existingGameStates = TableInfo.read(db, "game_states");
        if (!_infoGameStates.equals(_existingGameStates)) {
          return new RoomOpenHelper.ValidationResult(false, "game_states(com.ultimatelifesimulator.data.local.entity.GameStateEntity).\n"
                  + " Expected:\n" + _infoGameStates + "\n"
                  + " Found:\n" + _existingGameStates);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "e6344714017506aa48c9eae0de938e26", "c403b7f16964180bc775a8646cb64717");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "characters","traits","skills","locations","factions","relationships","items","game_events","health_records","game_states");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `characters`");
      _db.execSQL("DELETE FROM `traits`");
      _db.execSQL("DELETE FROM `skills`");
      _db.execSQL("DELETE FROM `locations`");
      _db.execSQL("DELETE FROM `factions`");
      _db.execSQL("DELETE FROM `relationships`");
      _db.execSQL("DELETE FROM `items`");
      _db.execSQL("DELETE FROM `game_events`");
      _db.execSQL("DELETE FROM `health_records`");
      _db.execSQL("DELETE FROM `game_states`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CharacterDao.class, CharacterDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TraitDao.class, TraitDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SkillDao.class, SkillDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(LocationDao.class, LocationDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FactionDao.class, FactionDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(RelationshipDao.class, RelationshipDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ItemDao.class, ItemDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(GameEventDao.class, GameEventDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(HealthRecordDao.class, HealthRecordDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(GameStateDao.class, GameStateDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public CharacterDao characterDao() {
    if (_characterDao != null) {
      return _characterDao;
    } else {
      synchronized(this) {
        if(_characterDao == null) {
          _characterDao = new CharacterDao_Impl(this);
        }
        return _characterDao;
      }
    }
  }

  @Override
  public TraitDao traitDao() {
    if (_traitDao != null) {
      return _traitDao;
    } else {
      synchronized(this) {
        if(_traitDao == null) {
          _traitDao = new TraitDao_Impl(this);
        }
        return _traitDao;
      }
    }
  }

  @Override
  public SkillDao skillDao() {
    if (_skillDao != null) {
      return _skillDao;
    } else {
      synchronized(this) {
        if(_skillDao == null) {
          _skillDao = new SkillDao_Impl(this);
        }
        return _skillDao;
      }
    }
  }

  @Override
  public LocationDao locationDao() {
    if (_locationDao != null) {
      return _locationDao;
    } else {
      synchronized(this) {
        if(_locationDao == null) {
          _locationDao = new LocationDao_Impl(this);
        }
        return _locationDao;
      }
    }
  }

  @Override
  public FactionDao factionDao() {
    if (_factionDao != null) {
      return _factionDao;
    } else {
      synchronized(this) {
        if(_factionDao == null) {
          _factionDao = new FactionDao_Impl(this);
        }
        return _factionDao;
      }
    }
  }

  @Override
  public RelationshipDao relationshipDao() {
    if (_relationshipDao != null) {
      return _relationshipDao;
    } else {
      synchronized(this) {
        if(_relationshipDao == null) {
          _relationshipDao = new RelationshipDao_Impl(this);
        }
        return _relationshipDao;
      }
    }
  }

  @Override
  public ItemDao itemDao() {
    if (_itemDao != null) {
      return _itemDao;
    } else {
      synchronized(this) {
        if(_itemDao == null) {
          _itemDao = new ItemDao_Impl(this);
        }
        return _itemDao;
      }
    }
  }

  @Override
  public GameEventDao gameEventDao() {
    if (_gameEventDao != null) {
      return _gameEventDao;
    } else {
      synchronized(this) {
        if(_gameEventDao == null) {
          _gameEventDao = new GameEventDao_Impl(this);
        }
        return _gameEventDao;
      }
    }
  }

  @Override
  public HealthRecordDao healthRecordDao() {
    if (_healthRecordDao != null) {
      return _healthRecordDao;
    } else {
      synchronized(this) {
        if(_healthRecordDao == null) {
          _healthRecordDao = new HealthRecordDao_Impl(this);
        }
        return _healthRecordDao;
      }
    }
  }

  @Override
  public GameStateDao gameStateDao() {
    if (_gameStateDao != null) {
      return _gameStateDao;
    } else {
      synchronized(this) {
        if(_gameStateDao == null) {
          _gameStateDao = new GameStateDao_Impl(this);
        }
        return _gameStateDao;
      }
    }
  }
}
