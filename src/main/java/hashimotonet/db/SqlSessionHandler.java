package hashimotonet.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import hashimotonet.bean.SampleBean;

public class SqlSessionHandler {

	public SqlSessionHandler() {
		super();
	}

	public List<Map<String, Object>> dbAccess() throws IOException {

		List<Map<String, Object>> result = null;

		// ★ルートとなる設定ファイルを読み込む
        try (InputStream in = this.getClass().getResourceAsStream("/mybatis-config.xml")) {
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

	public List<SampleBean> partialMatchByName(String name) throws IOException {
		List<SampleBean> match = new ArrayList<SampleBean>();

        try (InputStream in = this.getClass().getResourceAsStream("/mybatis-config.xml")) {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

            try (SqlSession session = factory.openSession()) {
                match = session.selectList("sample.mybatis.partialMatch");
            }
        }

		return match;
	}

}
