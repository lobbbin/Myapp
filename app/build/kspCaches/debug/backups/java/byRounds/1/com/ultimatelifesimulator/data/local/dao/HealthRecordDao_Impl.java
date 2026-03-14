package com.ultimatelifesimulator.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ultimatelifesimulator.data.local.entity.HealthRecordEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class HealthRecordDao_Impl implements HealthRecordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<HealthRecordEntity> __insertionAdapterOfHealthRecordEntity;

  private final EntityDeletionOrUpdateAdapter<HealthRecordEntity> __deletionAdapterOfHealthRecordEntity;

  private final EntityDeletionOrUpdateAdapter<HealthRecordEntity> __updateAdapterOfHealthRecordEntity;

  public HealthRecordDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHealthRecordEntity = new EntityInsertionAdapter<HealthRecordEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `health_records` (`id`,`characterId`,`type`,`severity`,`isChronic`,`isTreated`,`notes`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final HealthRecordEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCharacterId());
        statement.bindString(3, entity.getType());
        statement.bindLong(4, entity.getSeverity());
        final int _tmp = entity.isChronic() ? 1 : 0;
        statement.bindLong(5, _tmp);
        final int _tmp_1 = entity.isTreated() ? 1 : 0;
        statement.bindLong(6, _tmp_1);
        statement.bindString(7, entity.getNotes());
      }
    };
    this.__deletionAdapterOfHealthRecordEntity = new EntityDeletionOrUpdateAdapter<HealthRecordEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `health_records` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final HealthRecordEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfHealthRecordEntity = new EntityDeletionOrUpdateAdapter<HealthRecordEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `health_records` SET `id` = ?,`characterId` = ?,`type` = ?,`severity` = ?,`isChronic` = ?,`isTreated` = ?,`notes` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final HealthRecordEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCharacterId());
        statement.bindString(3, entity.getType());
        statement.bindLong(4, entity.getSeverity());
        final int _tmp = entity.isChronic() ? 1 : 0;
        statement.bindLong(5, _tmp);
        final int _tmp_1 = entity.isTreated() ? 1 : 0;
        statement.bindLong(6, _tmp_1);
        statement.bindString(7, entity.getNotes());
        statement.bindLong(8, entity.getId());
      }
    };
  }

  @Override
  public Object insertHealthRecord(final HealthRecordEntity record,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfHealthRecordEntity.insertAndReturnId(record);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertHealthRecords(final List<HealthRecordEntity> records,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfHealthRecordEntity.insert(records);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteHealthRecord(final HealthRecordEntity record,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfHealthRecordEntity.handle(record);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateHealthRecord(final HealthRecordEntity record,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfHealthRecordEntity.handle(record);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<HealthRecordEntity>> getHealthRecordsForCharacter(final long characterId) {
    final String _sql = "SELECT * FROM health_records WHERE characterId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, characterId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"health_records"}, new Callable<List<HealthRecordEntity>>() {
      @Override
      @NonNull
      public List<HealthRecordEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCharacterId = CursorUtil.getColumnIndexOrThrow(_cursor, "characterId");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfSeverity = CursorUtil.getColumnIndexOrThrow(_cursor, "severity");
          final int _cursorIndexOfIsChronic = CursorUtil.getColumnIndexOrThrow(_cursor, "isChronic");
          final int _cursorIndexOfIsTreated = CursorUtil.getColumnIndexOrThrow(_cursor, "isTreated");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final List<HealthRecordEntity> _result = new ArrayList<HealthRecordEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final HealthRecordEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpCharacterId;
            _tmpCharacterId = _cursor.getLong(_cursorIndexOfCharacterId);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final int _tmpSeverity;
            _tmpSeverity = _cursor.getInt(_cursorIndexOfSeverity);
            final boolean _tmpIsChronic;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsChronic);
            _tmpIsChronic = _tmp != 0;
            final boolean _tmpIsTreated;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsTreated);
            _tmpIsTreated = _tmp_1 != 0;
            final String _tmpNotes;
            _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            _item = new HealthRecordEntity(_tmpId,_tmpCharacterId,_tmpType,_tmpSeverity,_tmpIsChronic,_tmpIsTreated,_tmpNotes);
            _result.add(_item);
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

  @Override
  public Flow<List<HealthRecordEntity>> getHealthRecordsByType(final long characterId,
      final String type) {
    final String _sql = "SELECT * FROM health_records WHERE characterId = ? AND type = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, characterId);
    _argIndex = 2;
    _statement.bindString(_argIndex, type);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"health_records"}, new Callable<List<HealthRecordEntity>>() {
      @Override
      @NonNull
      public List<HealthRecordEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCharacterId = CursorUtil.getColumnIndexOrThrow(_cursor, "characterId");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfSeverity = CursorUtil.getColumnIndexOrThrow(_cursor, "severity");
          final int _cursorIndexOfIsChronic = CursorUtil.getColumnIndexOrThrow(_cursor, "isChronic");
          final int _cursorIndexOfIsTreated = CursorUtil.getColumnIndexOrThrow(_cursor, "isTreated");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final List<HealthRecordEntity> _result = new ArrayList<HealthRecordEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final HealthRecordEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpCharacterId;
            _tmpCharacterId = _cursor.getLong(_cursorIndexOfCharacterId);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final int _tmpSeverity;
            _tmpSeverity = _cursor.getInt(_cursorIndexOfSeverity);
            final boolean _tmpIsChronic;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsChronic);
            _tmpIsChronic = _tmp != 0;
            final boolean _tmpIsTreated;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsTreated);
            _tmpIsTreated = _tmp_1 != 0;
            final String _tmpNotes;
            _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            _item = new HealthRecordEntity(_tmpId,_tmpCharacterId,_tmpType,_tmpSeverity,_tmpIsChronic,_tmpIsTreated,_tmpNotes);
            _result.add(_item);
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
