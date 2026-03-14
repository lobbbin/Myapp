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
import com.ultimatelifesimulator.data.local.entity.GameEventEntity;
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
public final class GameEventDao_Impl implements GameEventDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GameEventEntity> __insertionAdapterOfGameEventEntity;

  private final EntityDeletionOrUpdateAdapter<GameEventEntity> __deletionAdapterOfGameEventEntity;

  public GameEventDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGameEventEntity = new EntityInsertionAdapter<GameEventEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `game_events` (`id`,`title`,`description`,`category`,`choices`,`triggerConditions`,`isRandom`,`weight`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final GameEventEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getTitle());
        statement.bindString(3, entity.getDescription());
        statement.bindString(4, entity.getCategory());
        statement.bindString(5, entity.getChoices());
        statement.bindString(6, entity.getTriggerConditions());
        final int _tmp = entity.isRandom() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindLong(8, entity.getWeight());
      }
    };
    this.__deletionAdapterOfGameEventEntity = new EntityDeletionOrUpdateAdapter<GameEventEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `game_events` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final GameEventEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
  }

  @Override
  public Object insertEvent(final GameEventEntity event,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfGameEventEntity.insertAndReturnId(event);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertEvents(final List<GameEventEntity> events,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfGameEventEntity.insert(events);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteEvent(final GameEventEntity event,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfGameEventEntity.handle(event);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<GameEventEntity>> getAllEvents() {
    final String _sql = "SELECT * FROM game_events";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"game_events"}, new Callable<List<GameEventEntity>>() {
      @Override
      @NonNull
      public List<GameEventEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfChoices = CursorUtil.getColumnIndexOrThrow(_cursor, "choices");
          final int _cursorIndexOfTriggerConditions = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerConditions");
          final int _cursorIndexOfIsRandom = CursorUtil.getColumnIndexOrThrow(_cursor, "isRandom");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final List<GameEventEntity> _result = new ArrayList<GameEventEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final GameEventEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            final String _tmpChoices;
            _tmpChoices = _cursor.getString(_cursorIndexOfChoices);
            final String _tmpTriggerConditions;
            _tmpTriggerConditions = _cursor.getString(_cursorIndexOfTriggerConditions);
            final boolean _tmpIsRandom;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsRandom);
            _tmpIsRandom = _tmp != 0;
            final int _tmpWeight;
            _tmpWeight = _cursor.getInt(_cursorIndexOfWeight);
            _item = new GameEventEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpCategory,_tmpChoices,_tmpTriggerConditions,_tmpIsRandom,_tmpWeight);
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
  public Flow<List<GameEventEntity>> getEventsByCategory(final String category) {
    final String _sql = "SELECT * FROM game_events WHERE category = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, category);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"game_events"}, new Callable<List<GameEventEntity>>() {
      @Override
      @NonNull
      public List<GameEventEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfChoices = CursorUtil.getColumnIndexOrThrow(_cursor, "choices");
          final int _cursorIndexOfTriggerConditions = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerConditions");
          final int _cursorIndexOfIsRandom = CursorUtil.getColumnIndexOrThrow(_cursor, "isRandom");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final List<GameEventEntity> _result = new ArrayList<GameEventEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final GameEventEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            final String _tmpChoices;
            _tmpChoices = _cursor.getString(_cursorIndexOfChoices);
            final String _tmpTriggerConditions;
            _tmpTriggerConditions = _cursor.getString(_cursorIndexOfTriggerConditions);
            final boolean _tmpIsRandom;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsRandom);
            _tmpIsRandom = _tmp != 0;
            final int _tmpWeight;
            _tmpWeight = _cursor.getInt(_cursorIndexOfWeight);
            _item = new GameEventEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpCategory,_tmpChoices,_tmpTriggerConditions,_tmpIsRandom,_tmpWeight);
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
  public Object getRandomEvent(final Continuation<? super GameEventEntity> $completion) {
    final String _sql = "SELECT * FROM game_events WHERE isRandom = 1 ORDER BY RANDOM() LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<GameEventEntity>() {
      @Override
      @Nullable
      public GameEventEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfChoices = CursorUtil.getColumnIndexOrThrow(_cursor, "choices");
          final int _cursorIndexOfTriggerConditions = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerConditions");
          final int _cursorIndexOfIsRandom = CursorUtil.getColumnIndexOrThrow(_cursor, "isRandom");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final GameEventEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            final String _tmpChoices;
            _tmpChoices = _cursor.getString(_cursorIndexOfChoices);
            final String _tmpTriggerConditions;
            _tmpTriggerConditions = _cursor.getString(_cursorIndexOfTriggerConditions);
            final boolean _tmpIsRandom;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsRandom);
            _tmpIsRandom = _tmp != 0;
            final int _tmpWeight;
            _tmpWeight = _cursor.getInt(_cursorIndexOfWeight);
            _result = new GameEventEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpCategory,_tmpChoices,_tmpTriggerConditions,_tmpIsRandom,_tmpWeight);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
