package top.zzh.service;

public interface RecommendService extends BaseService {
    int countTzm(String tjm);

    Object recommendRanking();

    Object getByTzm(String tzm);

    String getByUid(long uid);
}
