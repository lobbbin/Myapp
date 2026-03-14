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
import com.ultimatelifesimulator.data.local.entity.TraitEntity;
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
public final class TraitDao_Impl implements TraitDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TraitEntity> __insertionAdapterOfTraitEntity;

  private final EntityDeletionOrUpdateAdapter<TraitEntity> __deletionAdapterOfTraitEntity;

  public TraitDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTraitEntity = new EntityInsertionAdapter<TraitEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `traits` (`id`,`name`,`description`,`isPositive`,`isNegative`,`statModifiers`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TraitEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindString(3, entity.getDescription());
        final int _tmp = entity.isPositive() ? 1 : 0;
        statement.bindLong(4, _tmp);
        final int _tmp_1 = entity.isNegative() ? 1 : 0;
        statement.bindLong(5, _tmp_1);
        statement.bindString(6, entity.getStatModifiers());
      }
    };
    this.__deletionAdapterOfTraitEntity = new EntityDeletionOrUpdateAdapter<TraitEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `traits` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TraitEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
  }

  @Override
  public Object insertTrait(final TraitEntity trait, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfTraitEntity.insertAndReturnId(trait);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertTraits(final List<TraitEntity> traits,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTraitEntity.insert(traits);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteTrait(final TraitEntity trait, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfTraitEntity.handle(trait);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<TraitEntity>> getAllTraits() {
    final String _sql = "SELECT * FROM traits";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"traits"}, new Callable<List<TraitEntity>>() {
      @Override
      @NonNull
      public List<TraitEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfIsPositive = CursorUtil.getColumnIndexOrThrow(_cursor, "isPositive");
          final int _cursorIndexOfIsNegative = CursorUtil.getColumnIndexOrThrow(_cursor, "isNegative");
          final int _cursorIndexOfStatModifiers = CursorUtil.getColumnIndexOrThrow(_cursor, "statModifiers");
          final List<TraitEntity> _result = new ArrayList<TraitEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TraitEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final boolean _tmpIsPositive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPositive);
            _tmpIsPositive = _tmp != 0;
            final boolean _tmpIsNegative;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsNegative);
            _tmpIsNegative = _tmp_1 != 0;
            final String _tmpStatModifiers;
            _tmpStatModifiers = _cursor.getString(_cursorIndexOfStatModifiers);
            _item = new TraitEntity(_tmpId,_tmpName,_tmpDescription,_tmpIsPositive,_tmpIsNegative,_tmpStatModifiers);
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
  public Flow<List<TraitEntity>> getPositiveTraits() {
    final String _sql = "SELECT * FROM traits WHERE isPositive = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"traits"}, new Callable<List<TraitEntity>>() {
      @Override
      @NonNull
      public List<TraitEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfIsPositive = CursorUtil.getColumnIndexOrThrow(_cursor, "isPositive");
          final int _cursorIndexOfIsNegative = CursorUtil.getColumnIndexOrThrow(_cursor, "isNegative");
          final int _cursorIndexOfStatModifiers = CursorUtil.getColumnIndexOrThrow(_cursor, "statModifiers");
          final List<TraitEntity> _result = new ArrayList<TraitEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TraitEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final boolean _tmpIsPositive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPositive);
            _tmpIsPositive = _tmp != 0;
            final boolean _tmpIsNegative;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsNegative);
            _tmpIsNegative = _tmp_1 != 0;
            final String _tmpStatModifiers;
            _tmpStatModifiers = _cursor.getString(_cursorIndexOfStatModifiers);
            _item = new TraitEntity(_tmpId,_tmpName,_tmpDescription,_tmpIsPositive,_tmpIsNegative,_tmpStatModifiers);
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
  public Flow<List<TraitEntity>> getNegativeTraits() {
    final String _sql = "SELECT * FROM traits WHERE isNegative = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"traits"}, new Callable<List<TraitEntity>>() {
      @Override
      @NonNull
      public List<TraitEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfIsPositive = CursorUtil.getColumnIndexOrThrow(_cursor, "isPositive");
          final int _cursorIndexOfIsNegative = CursorUtil.getColumnIndexOrThrow(_cursor, "isNegative");
          final int _cursorIndexOfStatModifiers = CursorUtil.getColumnIndexOrThrow(_cursor, "statModifiers");
          final List<TraitEntity> _result = new ArrayList<TraitEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TraitEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final boolean _tmpIsPositive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPositive);
            _tmpIsPositive = _tmp != 0;
            final boolean _tmpIsNegative;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsNegative);
            _tmpIsNegative = _tmp_1 != 0;
            final String _tmpStatModifiers;
            _tmpStatModifiers = _cursor.getString(_cursorIndexOfStatModifiers);
            _item = new TraitEntity(_tmpId,_tmpName,_tmpDescription,_tmpIsPositive,_tmpIsNegative,_tmpStatModifiers);
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
