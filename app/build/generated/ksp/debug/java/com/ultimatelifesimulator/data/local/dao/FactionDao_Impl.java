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
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ultimatelifesimulator.data.local.entity.FactionEntity;
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
public final class FactionDao_Impl implements FactionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FactionEntity> __insertionAdapterOfFactionEntity;

  private final EntityDeletionOrUpdateAdapter<FactionEntity> __deletionAdapterOfFactionEntity;

  private final EntityDeletionOrUpdateAdapter<FactionEntity> __updateAdapterOfFactionEntity;

  public FactionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFactionEntity = new EntityInsertionAdapter<FactionEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `factions` (`id`,`name`,`type`,`power`,`opinionOfPlayer`,`description`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FactionEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindString(3, entity.getType());
        statement.bindLong(4, entity.getPower());
        statement.bindLong(5, entity.getOpinionOfPlayer());
        statement.bindString(6, entity.getDescription());
      }
    };
    this.__deletionAdapterOfFactionEntity = new EntityDeletionOrUpdateAdapter<FactionEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `factions` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FactionEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfFactionEntity = new EntityDeletionOrUpdateAdapter<FactionEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `factions` SET `id` = ?,`name` = ?,`type` = ?,`power` = ?,`opinionOfPlayer` = ?,`description` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FactionEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindString(3, entity.getType());
        statement.bindLong(4, entity.getPower());
        statement.bindLong(5, entity.getOpinionOfPlayer());
        statement.bindString(6, entity.getDescription());
        statement.bindLong(7, entity.getId());
      }
    };
  }

  @Override
  public Object insertFaction(final FactionEntity faction,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfFactionEntity.insertAndReturnId(faction);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertFactions(final List<FactionEntity> factions,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFactionEntity.insert(factions);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteFaction(final FactionEntity faction,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFactionEntity.handle(faction);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateFaction(final FactionEntity faction,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfFactionEntity.handle(faction);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<FactionEntity>> getAllFactions() {
    final String _sql = "SELECT * FROM factions";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"factions"}, new Callable<List<FactionEntity>>() {
      @Override
      @NonNull
      public List<FactionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfPower = CursorUtil.getColumnIndexOrThrow(_cursor, "power");
          final int _cursorIndexOfOpinionOfPlayer = CursorUtil.getColumnIndexOrThrow(_cursor, "opinionOfPlayer");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final List<FactionEntity> _result = new ArrayList<FactionEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FactionEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final int _tmpPower;
            _tmpPower = _cursor.getInt(_cursorIndexOfPower);
            final int _tmpOpinionOfPlayer;
            _tmpOpinionOfPlayer = _cursor.getInt(_cursorIndexOfOpinionOfPlayer);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item = new FactionEntity(_tmpId,_tmpName,_tmpType,_tmpPower,_tmpOpinionOfPlayer,_tmpDescription);
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
  public Object getFactionById(final long id,
      final Continuation<? super FactionEntity> $completion) {
    final String _sql = "SELECT * FROM factions WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<FactionEntity>() {
      @Override
      @Nullable
      public FactionEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfPower = CursorUtil.getColumnIndexOrThrow(_cursor, "power");
          final int _cursorIndexOfOpinionOfPlayer = CursorUtil.getColumnIndexOrThrow(_cursor, "opinionOfPlayer");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final FactionEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final int _tmpPower;
            _tmpPower = _cursor.getInt(_cursorIndexOfPower);
            final int _tmpOpinionOfPlayer;
            _tmpOpinionOfPlayer = _cursor.getInt(_cursorIndexOfOpinionOfPlayer);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _result = new FactionEntity(_tmpId,_tmpName,_tmpType,_tmpPower,_tmpOpinionOfPlayer,_tmpDescription);
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
  public Flow<List<FactionEntity>> getFactionsByType(final String type) {
    final String _sql = "SELECT * FROM factions WHERE type = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, type);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"factions"}, new Callable<List<FactionEntity>>() {
      @Override
      @NonNull
      public List<FactionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfPower = CursorUtil.getColumnIndexOrThrow(_cursor, "power");
          final int _cursorIndexOfOpinionOfPlayer = CursorUtil.getColumnIndexOrThrow(_cursor, "opinionOfPlayer");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final List<FactionEntity> _result = new ArrayList<FactionEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FactionEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final int _tmpPower;
            _tmpPower = _cursor.getInt(_cursorIndexOfPower);
            final int _tmpOpinionOfPlayer;
            _tmpOpinionOfPlayer = _cursor.getInt(_cursorIndexOfOpinionOfPlayer);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item = new FactionEntity(_tmpId,_tmpName,_tmpType,_tmpPower,_tmpOpinionOfPlayer,_tmpDescription);
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
