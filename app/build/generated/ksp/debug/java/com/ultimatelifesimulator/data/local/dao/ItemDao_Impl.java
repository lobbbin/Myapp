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
import com.ultimatelifesimulator.data.local.entity.ItemEntity;
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
public final class ItemDao_Impl implements ItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ItemEntity> __insertionAdapterOfItemEntity;

  private final EntityDeletionOrUpdateAdapter<ItemEntity> __deletionAdapterOfItemEntity;

  private final EntityDeletionOrUpdateAdapter<ItemEntity> __updateAdapterOfItemEntity;

  public ItemDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItemEntity = new EntityInsertionAdapter<ItemEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `items` (`id`,`name`,`category`,`value`,`weight`,`quantity`,`isEquipped`,`condition`,`characterId`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ItemEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindString(3, entity.getCategory());
        statement.bindDouble(4, entity.getValue());
        statement.bindDouble(5, entity.getWeight());
        statement.bindLong(6, entity.getQuantity());
        final int _tmp = entity.isEquipped() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindLong(8, entity.getCondition());
        statement.bindLong(9, entity.getCharacterId());
      }
    };
    this.__deletionAdapterOfItemEntity = new EntityDeletionOrUpdateAdapter<ItemEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `items` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ItemEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfItemEntity = new EntityDeletionOrUpdateAdapter<ItemEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `items` SET `id` = ?,`name` = ?,`category` = ?,`value` = ?,`weight` = ?,`quantity` = ?,`isEquipped` = ?,`condition` = ?,`characterId` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ItemEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindString(3, entity.getCategory());
        statement.bindDouble(4, entity.getValue());
        statement.bindDouble(5, entity.getWeight());
        statement.bindLong(6, entity.getQuantity());
        final int _tmp = entity.isEquipped() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindLong(8, entity.getCondition());
        statement.bindLong(9, entity.getCharacterId());
        statement.bindLong(10, entity.getId());
      }
    };
  }

  @Override
  public Object insertItem(final ItemEntity item, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfItemEntity.insertAndReturnId(item);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertItems(final List<ItemEntity> items,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfItemEntity.insert(items);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteItem(final ItemEntity item, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfItemEntity.handle(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateItem(final ItemEntity item, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfItemEntity.handle(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ItemEntity>> getItemsForCharacter(final long characterId) {
    final String _sql = "SELECT * FROM items WHERE characterId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, characterId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"items"}, new Callable<List<ItemEntity>>() {
      @Override
      @NonNull
      public List<ItemEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfIsEquipped = CursorUtil.getColumnIndexOrThrow(_cursor, "isEquipped");
          final int _cursorIndexOfCondition = CursorUtil.getColumnIndexOrThrow(_cursor, "condition");
          final int _cursorIndexOfCharacterId = CursorUtil.getColumnIndexOrThrow(_cursor, "characterId");
          final List<ItemEntity> _result = new ArrayList<ItemEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ItemEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            final double _tmpValue;
            _tmpValue = _cursor.getDouble(_cursorIndexOfValue);
            final double _tmpWeight;
            _tmpWeight = _cursor.getDouble(_cursorIndexOfWeight);
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            final boolean _tmpIsEquipped;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsEquipped);
            _tmpIsEquipped = _tmp != 0;
            final int _tmpCondition;
            _tmpCondition = _cursor.getInt(_cursorIndexOfCondition);
            final long _tmpCharacterId;
            _tmpCharacterId = _cursor.getLong(_cursorIndexOfCharacterId);
            _item = new ItemEntity(_tmpId,_tmpName,_tmpCategory,_tmpValue,_tmpWeight,_tmpQuantity,_tmpIsEquipped,_tmpCondition,_tmpCharacterId);
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
  public Flow<List<ItemEntity>> getItemsByCategory(final long characterId, final String category) {
    final String _sql = "SELECT * FROM items WHERE characterId = ? AND category = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, characterId);
    _argIndex = 2;
    _statement.bindString(_argIndex, category);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"items"}, new Callable<List<ItemEntity>>() {
      @Override
      @NonNull
      public List<ItemEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfIsEquipped = CursorUtil.getColumnIndexOrThrow(_cursor, "isEquipped");
          final int _cursorIndexOfCondition = CursorUtil.getColumnIndexOrThrow(_cursor, "condition");
          final int _cursorIndexOfCharacterId = CursorUtil.getColumnIndexOrThrow(_cursor, "characterId");
          final List<ItemEntity> _result = new ArrayList<ItemEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ItemEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            final double _tmpValue;
            _tmpValue = _cursor.getDouble(_cursorIndexOfValue);
            final double _tmpWeight;
            _tmpWeight = _cursor.getDouble(_cursorIndexOfWeight);
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            final boolean _tmpIsEquipped;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsEquipped);
            _tmpIsEquipped = _tmp != 0;
            final int _tmpCondition;
            _tmpCondition = _cursor.getInt(_cursorIndexOfCondition);
            final long _tmpCharacterId;
            _tmpCharacterId = _cursor.getLong(_cursorIndexOfCharacterId);
            _item = new ItemEntity(_tmpId,_tmpName,_tmpCategory,_tmpValue,_tmpWeight,_tmpQuantity,_tmpIsEquipped,_tmpCondition,_tmpCharacterId);
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
  public Flow<List<ItemEntity>> getEquippedItems(final long characterId) {
    final String _sql = "SELECT * FROM items WHERE characterId = ? AND isEquipped = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, characterId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"items"}, new Callable<List<ItemEntity>>() {
      @Override
      @NonNull
      public List<ItemEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfIsEquipped = CursorUtil.getColumnIndexOrThrow(_cursor, "isEquipped");
          final int _cursorIndexOfCondition = CursorUtil.getColumnIndexOrThrow(_cursor, "condition");
          final int _cursorIndexOfCharacterId = CursorUtil.getColumnIndexOrThrow(_cursor, "characterId");
          final List<ItemEntity> _result = new ArrayList<ItemEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ItemEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            final double _tmpValue;
            _tmpValue = _cursor.getDouble(_cursorIndexOfValue);
            final double _tmpWeight;
            _tmpWeight = _cursor.getDouble(_cursorIndexOfWeight);
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            final boolean _tmpIsEquipped;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsEquipped);
            _tmpIsEquipped = _tmp != 0;
            final int _tmpCondition;
            _tmpCondition = _cursor.getInt(_cursorIndexOfCondition);
            final long _tmpCharacterId;
            _tmpCharacterId = _cursor.getLong(_cursorIndexOfCharacterId);
            _item = new ItemEntity(_tmpId,_tmpName,_tmpCategory,_tmpValue,_tmpWeight,_tmpQuantity,_tmpIsEquipped,_tmpCondition,_tmpCharacterId);
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
