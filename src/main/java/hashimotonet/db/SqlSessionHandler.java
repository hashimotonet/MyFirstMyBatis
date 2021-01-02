package hashimotonet.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sample.mybatis.Main;

public class SqlSessionHandler {

	public SqlSessionHandler() {
		super();
	}

	public List<Map<String, Object>> dbAccess() throws IOException {

		List<Map<String, Object>> result = null;

		// ★ルートとなる設定ファイルを読み込む
        try (InputStream in = Main.class.getResourceAsStream("/mybatis-config.xml")) {
            // ★設定ファイルを元に、 SqlSessionFactory を作成する
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

            // ★SqlSessionFactory から SqlSession を生成する
            try (SqlSession session = factory.openSession()) {
                // ★SqlSession を使って SQL を実行する
                result = session.selectList("sample.mybatis.selectTest");
            }

        }

        return result;
	}

}
