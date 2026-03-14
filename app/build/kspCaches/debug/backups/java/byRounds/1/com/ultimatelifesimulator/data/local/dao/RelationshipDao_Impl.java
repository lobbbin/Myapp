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
import com.ultimatelifesimulator.data.local.entity.RelationshipEntity;
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
public final class RelationshipDao_Impl implements RelationshipDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<RelationshipEntity> __insertionAdapterOfRelationshipEntity;

  private final EntityDeletionOrUpdateAdapter<RelationshipEntity> __deletionAdapterOfRelationshipEntity;

  private final EntityDeletionOrUpdateAdapter<RelationshipEntity> __updateAdapterOfRelationshipEntity;

  public RelationshipDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRelationshipEntity = new EntityInsertionAdapter<RelationshipEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `relationships` (`id`,`characterId`,`targetCharacterId`,`type`,`score`,`trust`,`fear`,`respect`,`loyalty`,`debt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final RelationshipEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCharacterId());
        statement.bindLong(3, entity.getTargetCharacterId());
        statement.bindString(4, entity.getType());
        statement.bindLong(5, entity.getScore());
        statement.bindLong(6, entity.getTrust());
        statement.bindLong(7, entity.getFear());
        statement.bindLong(8, entity.getRespect());
        statement.bindLong(9, entity.getLoyalty());
        statement.bindLong(10, entity.getDebt());
      }
    };
    this.__deletionAdapterOfRelationshipEntity = new EntityDeletionOrUpdateAdapter<RelationshipEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `relationships` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final RelationshipEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfRelationshipEntity = new EntityDeletionOrUpdateAdapter<RelationshipEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `relationships` SET `id` = ?,`characterId` = ?,`targetCharacterId` = ?,`type` = ?,`score` = ?,`trust` = ?,`fear` = ?,`respect` = ?,`loyalty` = ?,`debt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final RelationshipEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCharacterId());
        statement.bindLong(3, entity.getTargetCharacterId());
        statement.bindString(4, entity.getType());
        statement.bindLong(5, entity.getScore());
        statement.bindLong(6, entity.getTrust());
        statement.bindLong(7, entity.getFear());
        statement.bindLong(8, entity.getRespect());
        statement.bindLong(9, entity.getLoyalty());
        statement.bindLong(10, entity.getDebt());
        statement.bindLong(11, entity.getId());
      }
    };
  }

  @Override
  public Object insertRelationship(final RelationshipEntity relationship,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfRelationshipEntity.insertAndReturnId(relationship);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertRelationships(final List<RelationshipEntity> relationships,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRelationshipEntity.insert(relationships);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteRelationship(final RelationshipEntity relationship,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfRelationshipEntity.handle(relationship);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateRelationship(final RelationshipEntity relationship,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfRelationshipEntity.handle(relationship);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<RelationshipEntity>> getRelationshipsForCharacter(final long characterId) {
    final String _sql = "SELECT * FROM relationships WHERE characterId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, characterId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"relationships"}, new Callable<List<RelationshipEntity>>() {
      @Override
      @NonNull
      public List<RelationshipEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCharacterId = CursorUtil.getColumnIndexOrThrow(_cursor, "characterId");
          final int _cursorIndexOfTargetCharacterId = CursorUtil.getColumnIndexOrThrow(_cursor, "targetCharacterId");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "score");
          final int _cursorIndexOfTrust = CursorUtil.getColumnIndexOrThrow(_cursor, "trust");
          final int _cursorIndexOfFear = CursorUtil.getColumnIndexOrThrow(_cursor, "fear");
          final int _cursorIndexOfRespect = CursorUtil.getColumnIndexOrThrow(_cursor, "respect");
          final int _cursorIndexOfLoyalty = CursorUtil.getColumnIndexOrThrow(_cursor, "loyalty");
          final int _cursorIndexOfDebt = CursorUtil.getColumnIndexOrThrow(_cursor, "debt");
          final List<RelationshipEntity> _result = new ArrayList<RelationshipEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final RelationshipEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpCharacterId;
            _tmpCharacterId = _cursor.getLong(_cursorIndexOfCharacterId);
            final long _tmpTargetCharacterId;
            _tmpTargetCharacterId = _cursor.getLong(_cursorIndexOfTargetCharacterId);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final int _tmpScore;
            _tmpScore = _cursor.getInt(_cursorIndexOfScore);
            final int _tmpTrust;
            _tmpTrust = _cursor.getInt(_cursorIndexOfTrust);
            final int _tmpFear;
            _tmpFear = _cursor.getInt(_cursorIndexOfFear);
            final int _tmpRespect;
            _tmpRespect = _cursor.getInt(_cursorIndexOfRespect);
            final int _tmpLoyalty;
            _tmpLoyalty = _cursor.getInt(_cursorIndexOfLoyalty);
            final int _tmpDebt;
            _tmpDebt = _cursor.getInt(_cursorIndexOfDebt);
            _item = new RelationshipEntity(_tmpId,_tmpCharacterId,_tmpTargetCharacterId,_tmpType,_tmpScore,_tmpTrust,_tmpFear,_tmpRespect,_tmpLoyalty,_tmpDebt);
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
  public Flow<List<RelationshipEntity>> getRelationshipsByType(final long characterId,
      final String type) {
    final String _sql = "SELECT * FROM relationships WHERE characterId = ? AND type = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, characterId);
    _argIndex = 2;
    _statement.bindString(_argIndex, type);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"relationships"}, new Callable<List<RelationshipEntity>>() {
      @Override
      @NonNull
      public List<RelationshipEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCharacterId = CursorUtil.getColumnIndexOrThrow(_cursor, "characterId");
          final int _cursorIndexOfTargetCharacterId = CursorUtil.getColumnIndexOrThrow(_cursor, "targetCharacterId");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "score");
          final int _cursorIndexOfTrust = CursorUtil.getColumnIndexOrThrow(_cursor, "trust");
          final int _cursorIndexOfFear = CursorUtil.getColumnIndexOrThrow(_cursor, "fear");
          final int _cursorIndexOfRespect = CursorUtil.getColumnIndexOrThrow(_cursor, "respect");
          final int _cursorIndexOfLoyalty = CursorUtil.getColumnIndexOrThrow(_cursor, "loyalty");
          final int _cursorIndexOfDebt = CursorUtil.getColumnIndexOrThrow(_cursor, "debt");
          final List<RelationshipEntity> _result = new ArrayList<RelationshipEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final RelationshipEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpCharacterId;
            _tmpCharacterId = _cursor.getLong(_cursorIndexOfCharacterId);
            final long _tmpTargetCharacterId;
            _tmpTargetCharacterId = _cursor.getLong(_cursorIndexOfTargetCharacterId);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final int _tmpScore;
            _tmpScore = _cursor.getInt(_cursorIndexOfScore);
            final int _tmpTrust;
            _tmpTrust = _cursor.getInt(_cursorIndexOfTrust);
            final int _tmpFear;
            _tmpFear = _cursor.getInt(_cursorIndexOfFear);
            final int _tmpRespect;
            _tmpRespect = _cursor.getInt(_cursorIndexOfRespect);
            final int _tmpLoyalty;
            _tmpLoyalty = _cursor.getInt(_cursorIndexOfLoyalty);
            final int _tmpDebt;
            _tmpDebt = _cursor.getInt(_cursorIndexOfDebt);
            _item = new RelationshipEntity(_tmpId,_tmpCharacterId,_tmpTargetCharacterId,_tmpType,_tmpScore,_tmpTrust,_tmpFear,_tmpRespect,_tmpLoyalty,_tmpDebt);
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
