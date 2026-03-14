package com.ultimatelifesimulator.data.local.dao;

import android.database.Cursor;
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
import com.ultimatelifesimulator.data.local.entity.GameStateEntity;
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
public final class GameStateDao_Impl implements GameStateDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GameStateEntity> __insertionAdapterOfGameStateEntity;

  private final EntityDeletionOrUpdateAdapter<GameStateEntity> __deletionAdapterOfGameStateEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteGameStateById;

  public GameStateDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGameStateEntity = new EntityInsertionAdapter<GameStateEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `game_states` (`id`,`characterId`,`savedAt`,`gameYear`,`gameMonth`,`gameDay`,`turnNumber`,`isAutoSave`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final GameStateEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCharacterId());
        statement.bindLong(3, entity.getSavedAt());
        statement.bindLong(4, entity.getGameYear());
        statement.bindLong(5, entity.getGameMonth());
        statement.bindLong(6, entity.getGameDay());
        statement.bindLong(7, entity.getTurnNumber());
        final int _tmp = entity.isAutoSave() ? 1 : 0;
        statement.bindLong(8, _tmp);
      }
    };
    this.__deletionAdapterOfGameStateEntity = new EntityDeletionOrUpdateAdapter<GameStateEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `game_states` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final GameStateEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteGameStateById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM game_states WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertGameState(final GameStateEntity gameState,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfGameStateEntity.insertAndReturnId(gameState);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteGameState(final GameStateEntity gameState,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfGameStateEntity.handle(gameState);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteGameStateById(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteGameStateById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfDeleteGameStateById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<GameStateEntity> getLatestGameState() {
    final String _sql = "SELECT * FROM game_states ORDER BY savedAt DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"game_states"}, new Callable<GameStateEntity>() {
      @Override
      @Nullable
      public GameStateEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCharacterId = CursorUtil.getColumnIndexOrThrow(_cursor, "characterId");
          final int _cursorIndexOfSavedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "savedAt");
          final int _cursorIndexOfGameYear = CursorUtil.getColumnIndexOrThrow(_cursor, "gameYear");
          final int _cursorIndexOfGameMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "gameMonth");
          final int _cursorIndexOfGameDay = CursorUtil.getColumnIndexOrThrow(_cursor, "gameDay");
          final int _cursorIndexOfTurnNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "turnNumber");
          final int _cursorIndexOfIsAutoSave = CursorUtil.getColumnIndexOrThrow(_cursor, "isAutoSave");
          final GameStateEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpCharacterId;
            _tmpCharacterId = _cursor.getLong(_cursorIndexOfCharacterId);
            final long _tmpSavedAt;
            _tmpSavedAt = _cursor.getLong(_cursorIndexOfSavedAt);
            final int _tmpGameYear;
            _tmpGameYear = _cursor.getInt(_cursorIndexOfGameYear);
            final int _tmpGameMonth;
            _tmpGameMonth = _cursor.getInt(_cursorIndexOfGameMonth);
            final int _tmpGameDay;
            _tmpGameDay = _cursor.getInt(_cursorIndexOfGameDay);
            final int _tmpTurnNumber;
            _tmpTurnNumber = _cursor.getInt(_cursorIndexOfTurnNumber);
            final boolean _tmpIsAutoSave;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAutoSave);
            _tmpIsAutoSave = _tmp != 0;
            _result = new GameStateEntity(_tmpId,_tmpCharacterId,_tmpSavedAt,_tmpGameYear,_tmpGameMonth,_tmpGameDay,_tmpTurnNumber,_tmpIsAutoSave);
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

  @Override
  public Flow<List<GameStateEntity>> getSavedGames() {
    final String _sql = "SELECT * FROM game_states WHERE isAutoSave = 0 ORDER BY savedAt DESC LIMIT 5";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"game_states"}, new Callable<List<GameStateEntity>>() {
      @Override
      @NonNull
      public List<GameStateEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCharacterId = CursorUtil.getColumnIndexOrThrow(_cursor, "characterId");
          final int _cursorIndexOfSavedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "savedAt");
          final int _cursorIndexOfGameYear = CursorUtil.getColumnIndexOrThrow(_cursor, "gameYear");
          final int _cursorIndexOfGameMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "gameMonth");
          final int _cursorIndexOfGameDay = CursorUtil.getColumnIndexOrThrow(_cursor, "gameDay");
          final int _cursorIndexOfTurnNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "turnNumber");
          final int _cursorIndexOfIsAutoSave = CursorUtil.getColumnIndexOrThrow(_cursor, "isAutoSave");
          final List<GameStateEntity> _result = new ArrayList<GameStateEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final GameStateEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpCharacterId;
            _tmpCharacterId = _cursor.getLong(_cursorIndexOfCharacterId);
            final long _tmpSavedAt;
            _tmpSavedAt = _cursor.getLong(_cursorIndexOfSavedAt);
            final int _tmpGameYear;
            _tmpGameYear = _cursor.getInt(_cursorIndexOfGameYear);
            final int _tmpGameMonth;
            _tmpGameMonth = _cursor.getInt(_cursorIndexOfGameMonth);
            final int _tmpGameDay;
            _tmpGameDay = _cursor.getInt(_cursorIndexOfGameDay);
            final int _tmpTurnNumber;
            _tmpTurnNumber = _cursor.getInt(_cursorIndexOfTurnNumber);
            final boolean _tmpIsAutoSave;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAutoSave);
            _tmpIsAutoSave = _tmp != 0;
            _item = new GameStateEntity(_tmpId,_tmpCharacterId,_tmpSavedAt,_tmpGameYear,_tmpGameMonth,_tmpGameDay,_tmpTurnNumber,_tmpIsAutoSave);
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
