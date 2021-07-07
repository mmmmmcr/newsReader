package com.example.data.repo.local;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NewsDao_Impl implements NewsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<NewsEntity> __insertionAdapterOfNewsEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllNews;

  public NewsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNewsEntity = new EntityInsertionAdapter<NewsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `news` (`id`,`title`,`image`,`newsDescription`,`newsContent`,`newsDate`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NewsEntity value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
        if (value.title == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.title);
        }
        if (value.image == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.image);
        }
        if (value.newsDescription == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.newsDescription);
        }
        if (value.newsContent == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.newsContent);
        }
        if (value.newsDate == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.newsDate);
        }
      }
    };
    this.__preparedStmtOfDeleteAllNews = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM news";
        return _query;
      }
    };
  }

  @Override
  public Completable insertArticles(final List<NewsEntity> news) {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfNewsEntity.insert(news);
          __db.setTransactionSuccessful();
          return null;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public Completable deleteAllNews() {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllNews.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return null;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllNews.release(_stmt);
        }
      }
    });
  }

  @Override
  public Single<List<NewsEntity>> queryNews() {
    final String _sql = "SELECT * FROM news";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createSingle(new Callable<List<NewsEntity>>() {
      @Override
      public List<NewsEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfNewsDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "newsDescription");
          final int _cursorIndexOfNewsContent = CursorUtil.getColumnIndexOrThrow(_cursor, "newsContent");
          final int _cursorIndexOfNewsDate = CursorUtil.getColumnIndexOrThrow(_cursor, "newsDate");
          final List<NewsEntity> _result = new ArrayList<NewsEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final NewsEntity _item;
            _item = new NewsEntity();
            if (_cursor.isNull(_cursorIndexOfId)) {
              _item.id = null;
            } else {
              _item.id = _cursor.getInt(_cursorIndexOfId);
            }
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _item.title = null;
            } else {
              _item.title = _cursor.getString(_cursorIndexOfTitle);
            }
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _item.image = null;
            } else {
              _item.image = _cursor.getString(_cursorIndexOfImage);
            }
            if (_cursor.isNull(_cursorIndexOfNewsDescription)) {
              _item.newsDescription = null;
            } else {
              _item.newsDescription = _cursor.getString(_cursorIndexOfNewsDescription);
            }
            if (_cursor.isNull(_cursorIndexOfNewsContent)) {
              _item.newsContent = null;
            } else {
              _item.newsContent = _cursor.getString(_cursorIndexOfNewsContent);
            }
            if (_cursor.isNull(_cursorIndexOfNewsDate)) {
              _item.newsDate = null;
            } else {
              _item.newsDate = _cursor.getString(_cursorIndexOfNewsDate);
            }
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
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
  public Single<NewsEntity> queryNewsItem(final int id) {
    final String _sql = "SELECT * FROM news where id= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return RxRoom.createSingle(new Callable<NewsEntity>() {
      @Override
      public NewsEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfNewsDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "newsDescription");
          final int _cursorIndexOfNewsContent = CursorUtil.getColumnIndexOrThrow(_cursor, "newsContent");
          final int _cursorIndexOfNewsDate = CursorUtil.getColumnIndexOrThrow(_cursor, "newsDate");
          final NewsEntity _result;
          if(_cursor.moveToFirst()) {
            _result = new NewsEntity();
            if (_cursor.isNull(_cursorIndexOfId)) {
              _result.id = null;
            } else {
              _result.id = _cursor.getInt(_cursorIndexOfId);
            }
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _result.title = null;
            } else {
              _result.title = _cursor.getString(_cursorIndexOfTitle);
            }
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _result.image = null;
            } else {
              _result.image = _cursor.getString(_cursorIndexOfImage);
            }
            if (_cursor.isNull(_cursorIndexOfNewsDescription)) {
              _result.newsDescription = null;
            } else {
              _result.newsDescription = _cursor.getString(_cursorIndexOfNewsDescription);
            }
            if (_cursor.isNull(_cursorIndexOfNewsContent)) {
              _result.newsContent = null;
            } else {
              _result.newsContent = _cursor.getString(_cursorIndexOfNewsContent);
            }
            if (_cursor.isNull(_cursorIndexOfNewsDate)) {
              _result.newsDate = null;
            } else {
              _result.newsDate = _cursor.getString(_cursorIndexOfNewsDate);
            }
          } else {
            _result = null;
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
