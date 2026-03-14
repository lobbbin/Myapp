package com.ultimatelifesimulator.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ultimatelifesimulator.data.local.entity.CharacterEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class CharacterDao_Impl implements CharacterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CharacterEntity> __insertionAdapterOfCharacterEntity;

  private final EntityDeletionOrUpdateAdapter<CharacterEntity> __deletionAdapterOfCharacterEntity;

  private final EntityDeletionOrUpdateAdapter<CharacterEntity> __updateAdapterOfCharacterEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllCharacters;

  public CharacterDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCharacterEntity = new EntityInsertionAdapter<CharacterEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `characters` (`id`,`name`,`age`,`gender`,`birthDay`,`birthMonth`,`birthYear`,`health`,`energy`,`stress`,`charisma`,`intellect`,`cunning`,`violence`,`stealth`,`perception`,`willpower`,`reputation`,`wealth`,`piety`,`loyalty`,`addiction`,`heat`,`education`,`streetCred`,`nobleStanding`,`politicalCapital`,`lifePath`,`currentLocationId`,`gameYear`,`gameDay`,`gameMonth`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CharacterEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindLong(3, entity.getAge());
        statement.bindString(4, entity.getGender());
        statement.bindLong(5, entity.getBirthDay());
        statement.bindLong(6, entity.getBirthMonth());
        statement.bindLong(7, entity.getBirthYear());
        statement.bindLong(8, entity.getHealth());
        statement.bindLong(9, entity.getEnergy());
        statement.bindLong(10, entity.getStress());
        statement.bindLong(11, entity.getCharisma());
        statement.bindLong(12, entity.getIntellect());
        statement.bindLong(13, entity.getCunning());
        statement.bindLong(14, entity.getViolence());
        statement.bindLong(15, entity.getStealth());
        statement.bindLong(16, entity.getPerception());
        statement.bindLong(17, entity.getWillpower());
        statement.bindLong(18, entity.getReputation());
        statement.bindDouble(19, entity.getWealth());
        statement.bindLong(20, entity.getPiety());
        statement.bindLong(21, entity.getLoyalty());
        statement.bindLong(22, entity.getAddiction());
        statement.bindLong(23, entity.getHeat());
        statement.bindLong(24, entity.getEducation());
        statement.bindLong(25, entity.getStreetCred());
        statement.bindLong(26, entity.getNobleStanding());
        statement.bindLong(27, entity.getPoliticalCapital());
        statement.bindString(28, entity.getLifePath());
        statement.bindLong(29, entity.getCurrentLocationId());
        statement.bindLong(30, entity.getGameYear());
        statement.bindLong(31, entity.getGameDay());
        statement.bindLong(32, entity.getGameMonth());
      }
    };
    this.__deletionAdapterOfCharacterEntity = new EntityDeletionOrUpdateAdapter<CharacterEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `characters` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CharacterEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfCharacterEntity = new EntityDeletionOrUpdateAdapter<CharacterEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `characters` SET `id` = ?,`name` = ?,`age` = ?,`gender` = ?,`birthDay` = ?,`birthMonth` = ?,`birthYear` = ?,`health` = ?,`energy` = ?,`stress` = ?,`charisma` = ?,`intellect` = ?,`cunning` = ?,`violence` = ?,`stealth` = ?,`perception` = ?,`willpower` = ?,`reputation` = ?,`wealth` = ?,`piety` = ?,`loyalty` = ?,`addiction` = ?,`heat` = ?,`education` = ?,`streetCred` = ?,`nobleStanding` = ?,`politicalCapital` = ?,`lifePath` = ?,`currentLocationId` = ?,`gameYear` = ?,`gameDay` = ?,`gameMonth` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CharacterEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindLong(3, entity.getAge());
        statement.bindString(4, entity.getGender());
        statement.bindLong(5, entity.getBirthDay());
        statement.bindLong(6, entity.getBirthMonth());
        statement.bindLong(7, entity.getBirthYear());
        statement.bindLong(8, entity.getHealth());
        statement.bindLong(9, entity.getEnergy());
        statement.bindLong(10, entity.getStress());
        statement.bindLong(11, entity.getCharisma());
        statement.bindLong(12, entity.getIntellect());
        statement.bindLong(13, entity.getCunning());
        statement.bindLong(14, entity.getViolence());
        statement.bindLong(15, entity.getStealth());
        statement.bindLong(16, entity.getPerception());
        statement.bindLong(17, entity.getWillpower());
        statement.bindLong(18, entity.getReputation());
        statement.bindDouble(19, entity.getWealth());
        statement.bindLong(20, entity.getPiety());
        statement.bindLong(21, entity.getLoyalty());
        statement.bindLong(22, entity.getAddiction());
        statement.bindLong(23, entity.getHeat());
        statement.bindLong(24, entity.getEducation());
        statement.bindLong(25, entity.getStreetCred());
        statement.bindLong(26, entity.getNobleStanding());
        statement.bindLong(27, entity.getPoliticalCapital());
        statement.bindString(28, entity.getLifePath());
        statement.bindLong(29, entity.getCurrentLocationId());
        statement.bindLong(30, entity.getGameYear());
        statement.bindLong(31, entity.getGameDay());
        statement.bindLong(32, entity.getGameMonth());
        statement.bindLong(33, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteAllCharacters = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM characters";
        return _query;
      }
    };
  }

  @Override
  public Object insertCharacter(final CharacterEntity character,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfCharacterEntity.insertAndReturnId(character);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteCharacter(final CharacterEntity character,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfCharacterEntity.handle(character);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateCharacter(final CharacterEntity character,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfCharacterEntity.handle(character);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllCharacters(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllCharacters.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllCharacters.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getCharacterById(final long id,
      final Continuation<? super CharacterEntity> $completion) {
    final String _sql = "SELECT * FROM characters WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<CharacterEntity>() {
      @Override
      @Nullable
      public CharacterEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfBirthDay = CursorUtil.getColumnIndexOrThrow(_cursor, "birthDay");
          final int _cursorIndexOfBirthMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "birthMonth");
          final int _cursorIndexOfBirthYear = CursorUtil.getColumnIndexOrThrow(_cursor, "birthYear");
          final int _cursorIndexOfHealth = CursorUtil.getColumnIndexOrThrow(_cursor, "health");
          final int _cursorIndexOfEnergy = CursorUtil.getColumnIndexOrThrow(_cursor, "energy");
          final int _cursorIndexOfStress = CursorUtil.getColumnIndexOrThrow(_cursor, "stress");
          final int _cursorIndexOfCharisma = CursorUtil.getColumnIndexOrThrow(_cursor, "charisma");
          final int _cursorIndexOfIntellect = CursorUtil.getColumnIndexOrThrow(_cursor, "intellect");
          final int _cursorIndexOfCunning = CursorUtil.getColumnIndexOrThrow(_cursor, "cunning");
          final int _cursorIndexOfViolence = CursorUtil.getColumnIndexOrThrow(_cursor, "violence");
          final int _cursorIndexOfStealth = CursorUtil.getColumnIndexOrThrow(_cursor, "stealth");
          final int _cursorIndexOfPerception = CursorUtil.getColumnIndexOrThrow(_cursor, "perception");
          final int _cursorIndexOfWillpower = CursorUtil.getColumnIndexOrThrow(_cursor, "willpower");
          final int _cursorIndexOfReputation = CursorUtil.getColumnIndexOrThrow(_cursor, "reputation");
          final int _cursorIndexOfWealth = CursorUtil.getColumnIndexOrThrow(_cursor, "wealth");
          final int _cursorIndexOfPiety = CursorUtil.getColumnIndexOrThrow(_cursor, "piety");
          final int _cursorIndexOfLoyalty = CursorUtil.getColumnIndexOrThrow(_cursor, "loyalty");
          final int _cursorIndexOfAddiction = CursorUtil.getColumnIndexOrThrow(_cursor, "addiction");
          final int _cursorIndexOfHeat = CursorUtil.getColumnIndexOrThrow(_cursor, "heat");
          final int _cursorIndexOfEducation = CursorUtil.getColumnIndexOrThrow(_cursor, "education");
          final int _cursorIndexOfStreetCred = CursorUtil.getColumnIndexOrThrow(_cursor, "streetCred");
          final int _cursorIndexOfNobleStanding = CursorUtil.getColumnIndexOrThrow(_cursor, "nobleStanding");
          final int _cursorIndexOfPoliticalCapital = CursorUtil.getColumnIndexOrThrow(_cursor, "politicalCapital");
          final int _cursorIndexOfLifePath = CursorUtil.getColumnIndexOrThrow(_cursor, "lifePath");
          final int _cursorIndexOfCurrentLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "currentLocationId");
          final int _cursorIndexOfGameYear = CursorUtil.getColumnIndexOrThrow(_cursor, "gameYear");
          final int _cursorIndexOfGameDay = CursorUtil.getColumnIndexOrThrow(_cursor, "gameDay");
          final int _cursorIndexOfGameMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "gameMonth");
          final CharacterEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            final int _tmpBirthDay;
            _tmpBirthDay = _cursor.getInt(_cursorIndexOfBirthDay);
            final int _tmpBirthMonth;
            _tmpBirthMonth = _cursor.getInt(_cursorIndexOfBirthMonth);
            final int _tmpBirthYear;
            _tmpBirthYear = _cursor.getInt(_cursorIndexOfBirthYear);
            final int _tmpHealth;
            _tmpHealth = _cursor.getInt(_cursorIndexOfHealth);
            final int _tmpEnergy;
            _tmpEnergy = _cursor.getInt(_cursorIndexOfEnergy);
            final int _tmpStress;
            _tmpStress = _cursor.getInt(_cursorIndexOfStress);
            final int _tmpCharisma;
            _tmpCharisma = _cursor.getInt(_cursorIndexOfCharisma);
            final int _tmpIntellect;
            _tmpIntellect = _cursor.getInt(_cursorIndexOfIntellect);
            final int _tmpCunning;
            _tmpCunning = _cursor.getInt(_cursorIndexOfCunning);
            final int _tmpViolence;
            _tmpViolence = _cursor.getInt(_cursorIndexOfViolence);
            final int _tmpStealth;
            _tmpStealth = _cursor.getInt(_cursorIndexOfStealth);
            final int _tmpPerception;
            _tmpPerception = _cursor.getInt(_cursorIndexOfPerception);
            final int _tmpWillpower;
            _tmpWillpower = _cursor.getInt(_cursorIndexOfWillpower);
            final int _tmpReputation;
            _tmpReputation = _cursor.getInt(_cursorIndexOfReputation);
            final double _tmpWealth;
            _tmpWealth = _cursor.getDouble(_cursorIndexOfWealth);
            final int _tmpPiety;
            _tmpPiety = _cursor.getInt(_cursorIndexOfPiety);
            final int _tmpLoyalty;
            _tmpLoyalty = _cursor.getInt(_cursorIndexOfLoyalty);
            final int _tmpAddiction;
            _tmpAddiction = _cursor.getInt(_cursorIndexOfAddiction);
            final int _tmpHeat;
            _tmpHeat = _cursor.getInt(_cursorIndexOfHeat);
            final int _tmpEducation;
            _tmpEducation = _cursor.getInt(_cursorIndexOfEducation);
            final int _tmpStreetCred;
            _tmpStreetCred = _cursor.getInt(_cursorIndexOfStreetCred);
            final int _tmpNobleStanding;
            _tmpNobleStanding = _cursor.getInt(_cursorIndexOfNobleStanding);
            final int _tmpPoliticalCapital;
            _tmpPoliticalCapital = _cursor.getInt(_cursorIndexOfPoliticalCapital);
            final String _tmpLifePath;
            _tmpLifePath = _cursor.getString(_cursorIndexOfLifePath);
            final long _tmpCurrentLocationId;
            _tmpCurrentLocationId = _cursor.getLong(_cursorIndexOfCurrentLocationId);
            final int _tmpGameYear;
            _tmpGameYear = _cursor.getInt(_cursorIndexOfGameYear);
            final int _tmpGameDay;
            _tmpGameDay = _cursor.getInt(_cursorIndexOfGameDay);
            final int _tmpGameMonth;
            _tmpGameMonth = _cursor.getInt(_cursorIndexOfGameMonth);
            _result = new CharacterEntity(_tmpId,_tmpName,_tmpAge,_tmpGender,_tmpBirthDay,_tmpBirthMonth,_tmpBirthYear,_tmpHealth,_tmpEnergy,_tmpStress,_tmpCharisma,_tmpIntellect,_tmpCunning,_tmpViolence,_tmpStealth,_tmpPerception,_tmpWillpower,_tmpReputation,_tmpWealth,_tmpPiety,_tmpLoyalty,_tmpAddiction,_tmpHeat,_tmpEducation,_tmpStreetCred,_tmpNobleStanding,_tmpPoliticalCapital,_tmpLifePath,_tmpCurrentLocationId,_tmpGameYear,_tmpGameDay,_tmpGameMonth);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<CharacterEntity> getCurrentCharacter() {
    final String _sql = "SELECT * FROM characters LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"characters"}, new Callable<CharacterEntity>() {
      @Override
      @Nullable
      public CharacterEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfBirthDay = CursorUtil.getColumnIndexOrThrow(_cursor, "birthDay");
          final int _cursorIndexOfBirthMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "birthMonth");
          final int _cursorIndexOfBirthYear = CursorUtil.getColumnIndexOrThrow(_cursor, "birthYear");
          final int _cursorIndexOfHealth = CursorUtil.getColumnIndexOrThrow(_cursor, "health");
          final int _cursorIndexOfEnergy = CursorUtil.getColumnIndexOrThrow(_cursor, "energy");
          final int _cursorIndexOfStress = CursorUtil.getColumnIndexOrThrow(_cursor, "stress");
          final int _cursorIndexOfCharisma = CursorUtil.getColumnIndexOrThrow(_cursor, "charisma");
          final int _cursorIndexOfIntellect = CursorUtil.getColumnIndexOrThrow(_cursor, "intellect");
          final int _cursorIndexOfCunning = CursorUtil.getColumnIndexOrThrow(_cursor, "cunning");
          final int _cursorIndexOfViolence = CursorUtil.getColumnIndexOrThrow(_cursor, "violence");
          final int _cursorIndexOfStealth = CursorUtil.getColumnIndexOrThrow(_cursor, "stealth");
          final int _cursorIndexOfPerception = CursorUtil.getColumnIndexOrThrow(_cursor, "perception");
          final int _cursorIndexOfWillpower = CursorUtil.getColumnIndexOrThrow(_cursor, "willpower");
          final int _cursorIndexOfReputation = CursorUtil.getColumnIndexOrThrow(_cursor, "reputation");
          final int _cursorIndexOfWealth = CursorUtil.getColumnIndexOrThrow(_cursor, "wealth");
          final int _cursorIndexOfPiety = CursorUtil.getColumnIndexOrThrow(_cursor, "piety");
          final int _cursorIndexOfLoyalty = CursorUtil.getColumnIndexOrThrow(_cursor, "loyalty");
          final int _cursorIndexOfAddiction = CursorUtil.getColumnIndexOrThrow(_cursor, "addiction");
          final int _cursorIndexOfHeat = CursorUtil.getColumnIndexOrThrow(_cursor, "heat");
          final int _cursorIndexOfEducation = CursorUtil.getColumnIndexOrThrow(_cursor, "education");
          final int _cursorIndexOfStreetCred = CursorUtil.getColumnIndexOrThrow(_cursor, "streetCred");
          final int _cursorIndexOfNobleStanding = CursorUtil.getColumnIndexOrThrow(_cursor, "nobleStanding");
          final int _cursorIndexOfPoliticalCapital = CursorUtil.getColumnIndexOrThrow(_cursor, "politicalCapital");
          final int _cursorIndexOfLifePath = CursorUtil.getColumnIndexOrThrow(_cursor, "lifePath");
          final int _cursorIndexOfCurrentLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "currentLocationId");
          final int _cursorIndexOfGameYear = CursorUtil.getColumnIndexOrThrow(_cursor, "gameYear");
          final int _cursorIndexOfGameDay = CursorUtil.getColumnIndexOrThrow(_cursor, "gameDay");
          final int _cursorIndexOfGameMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "gameMonth");
          final CharacterEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            final int _tmpBirthDay;
            _tmpBirthDay = _cursor.getInt(_cursorIndexOfBirthDay);
            final int _tmpBirthMonth;
            _tmpBirthMonth = _cursor.getInt(_cursorIndexOfBirthMonth);
            final int _tmpBirthYear;
            _tmpBirthYear = _cursor.getInt(_cursorIndexOfBirthYear);
            final int _tmpHealth;
            _tmpHealth = _cursor.getInt(_cursorIndexOfHealth);
            final int _tmpEnergy;
            _tmpEnergy = _cursor.getInt(_cursorIndexOfEnergy);
            final int _tmpStress;
            _tmpStress = _cursor.getInt(_cursorIndexOfStress);
            final int _tmpCharisma;
            _tmpCharisma = _cursor.getInt(_cursorIndexOfCharisma);
            final int _tmpIntellect;
            _tmpIntellect = _cursor.getInt(_cursorIndexOfIntellect);
            final int _tmpCunning;
            _tmpCunning = _cursor.getInt(_cursorIndexOfCunning);
            final int _tmpViolence;
            _tmpViolence = _cursor.getInt(_cursorIndexOfViolence);
            final int _tmpStealth;
            _tmpStealth = _cursor.getInt(_cursorIndexOfStealth);
            final int _tmpPerception;
            _tmpPerception = _cursor.getInt(_cursorIndexOfPerception);
            final int _tmpWillpower;
            _tmpWillpower = _cursor.getInt(_cursorIndexOfWillpower);
            final int _tmpReputation;
            _tmpReputation = _cursor.getInt(_cursorIndexOfReputation);
            final double _tmpWealth;
            _tmpWealth = _cursor.getDouble(_cursorIndexOfWealth);
            final int _tmpPiety;
            _tmpPiety = _cursor.getInt(_cursorIndexOfPiety);
            final int _tmpLoyalty;
            _tmpLoyalty = _cursor.getInt(_cursorIndexOfLoyalty);
            final int _tmpAddiction;
            _tmpAddiction = _cursor.getInt(_cursorIndexOfAddiction);
            final int _tmpHeat;
            _tmpHeat = _cursor.getInt(_cursorIndexOfHeat);
            final int _tmpEducation;
            _tmpEducation = _cursor.getInt(_cursorIndexOfEducation);
            final int _tmpStreetCred;
            _tmpStreetCred = _cursor.getInt(_cursorIndexOfStreetCred);
            final int _tmpNobleStanding;
            _tmpNobleStanding = _cursor.getInt(_cursorIndexOfNobleStanding);
            final int _tmpPoliticalCapital;
            _tmpPoliticalCapital = _cursor.getInt(_cursorIndexOfPoliticalCapital);
            final String _tmpLifePath;
            _tmpLifePath = _cursor.getString(_cursorIndexOfLifePath);
            final long _tmpCurrentLocationId;
            _tmpCurrentLocationId = _cursor.getLong(_cursorIndexOfCurrentLocationId);
            final int _tmpGameYear;
            _tmpGameYear = _cursor.getInt(_cursorIndexOfGameYear);
            final int _tmpGameDay;
            _tmpGameDay = _cursor.getInt(_cursorIndexOfGameDay);
            final int _tmpGameMonth;
            _tmpGameMonth = _cursor.getInt(_cursorIndexOfGameMonth);
            _result = new CharacterEntity(_tmpId,_tmpName,_tmpAge,_tmpGender,_tmpBirthDay,_tmpBirthMonth,_tmpBirthYear,_tmpHealth,_tmpEnergy,_tmpStress,_tmpCharisma,_tmpIntellect,_tmpCunning,_tmpViolence,_tmpStealth,_tmpPerception,_tmpWillpower,_tmpReputation,_tmpWealth,_tmpPiety,_tmpLoyalty,_tmpAddiction,_tmpHeat,_tmpEducation,_tmpStreetCred,_tmpNobleStanding,_tmpPoliticalCapital,_tmpLifePath,_tmpCurrentLocationId,_tmpGameYear,_tmpGameDay,_tmpGameMonth);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
