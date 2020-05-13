package job.common.nhlngCommon.dataAccess.entity.nhlng;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CmtSystemStatExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.cmt_system_stat
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.cmt_system_stat
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.cmt_system_stat
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    protected Criteria criteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_system_stat
     *
     * @mbg.generated
     */
    public CmtSystemStatExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_system_stat
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_system_stat
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_system_stat
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_system_stat
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_system_stat
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_system_stat
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_system_stat
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_system_stat
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    public Criteria addCriteria() {
            oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_system_stat
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_system_stat
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.cmt_system_stat
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andSccServerNameIsNull() {
            addCriterion("scc_server_name is null");
            return (Criteria) this;
        }

        public Criteria andSccServerNameIsNotNull() {
            addCriterion("scc_server_name is not null");
            return (Criteria) this;
        }

        public Criteria andSccServerNameEqualTo(String value) {
            addCriterion("scc_server_name =", value, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameNotEqualTo(String value) {
            addCriterion("scc_server_name <>", value, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameGreaterThan(String value) {
            addCriterion("scc_server_name >", value, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameGreaterThanOrEqualTo(String value) {
            addCriterion("scc_server_name >=", value, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameLessThan(String value) {
            addCriterion("scc_server_name <", value, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameLessThanOrEqualTo(String value) {
            addCriterion("scc_server_name <=", value, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameLike(String value) {
            addCriterion("scc_server_name like", value, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameNotLike(String value) {
            addCriterion("scc_server_name not like", value, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameIn(List<String> values) {
            addCriterion("scc_server_name in", values, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameNotIn(List<String> values) {
            addCriterion("scc_server_name not in", values, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameBetween(String value1, String value2) {
            addCriterion("scc_server_name between", value1, value2, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameNotBetween(String value1, String value2) {
            addCriterion("scc_server_name not between", value1, value2, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andMasterStatIsNull() {
            addCriterion("master_stat is null");
            return (Criteria) this;
        }

        public Criteria andMasterStatIsNotNull() {
            addCriterion("master_stat is not null");
            return (Criteria) this;
        }

        public Criteria andMasterStatEqualTo(Integer value) {
            addCriterion("master_stat =", value, "masterStat");
            return (Criteria) this;
        }

        public Criteria andMasterStatNotEqualTo(Integer value) {
            addCriterion("master_stat <>", value, "masterStat");
            return (Criteria) this;
        }

        public Criteria andMasterStatGreaterThan(Integer value) {
            addCriterion("master_stat >", value, "masterStat");
            return (Criteria) this;
        }

        public Criteria andMasterStatGreaterThanOrEqualTo(Integer value) {
            addCriterion("master_stat >=", value, "masterStat");
            return (Criteria) this;
        }

        public Criteria andMasterStatLessThan(Integer value) {
            addCriterion("master_stat <", value, "masterStat");
            return (Criteria) this;
        }

        public Criteria andMasterStatLessThanOrEqualTo(Integer value) {
            addCriterion("master_stat <=", value, "masterStat");
            return (Criteria) this;
        }

        public Criteria andMasterStatIn(List<Integer> values) {
            addCriterion("master_stat in", values, "masterStat");
            return (Criteria) this;
        }

        public Criteria andMasterStatNotIn(List<Integer> values) {
            addCriterion("master_stat not in", values, "masterStat");
            return (Criteria) this;
        }

        public Criteria andMasterStatBetween(Integer value1, Integer value2) {
            addCriterion("master_stat between", value1, value2, "masterStat");
            return (Criteria) this;
        }

        public Criteria andMasterStatNotBetween(Integer value1, Integer value2) {
            addCriterion("master_stat not between", value1, value2, "masterStat");
            return (Criteria) this;
        }

        public Criteria andProcExecStatIsNull() {
            addCriterion("proc_exec_stat is null");
            return (Criteria) this;
        }

        public Criteria andProcExecStatIsNotNull() {
            addCriterion("proc_exec_stat is not null");
            return (Criteria) this;
        }

        public Criteria andProcExecStatEqualTo(Integer value) {
            addCriterion("proc_exec_stat =", value, "procExecStat");
            return (Criteria) this;
        }

        public Criteria andProcExecStatNotEqualTo(Integer value) {
            addCriterion("proc_exec_stat <>", value, "procExecStat");
            return (Criteria) this;
        }

        public Criteria andProcExecStatGreaterThan(Integer value) {
            addCriterion("proc_exec_stat >", value, "procExecStat");
            return (Criteria) this;
        }

        public Criteria andProcExecStatGreaterThanOrEqualTo(Integer value) {
            addCriterion("proc_exec_stat >=", value, "procExecStat");
            return (Criteria) this;
        }

        public Criteria andProcExecStatLessThan(Integer value) {
            addCriterion("proc_exec_stat <", value, "procExecStat");
            return (Criteria) this;
        }

        public Criteria andProcExecStatLessThanOrEqualTo(Integer value) {
            addCriterion("proc_exec_stat <=", value, "procExecStat");
            return (Criteria) this;
        }

        public Criteria andProcExecStatIn(List<Integer> values) {
            addCriterion("proc_exec_stat in", values, "procExecStat");
            return (Criteria) this;
        }

        public Criteria andProcExecStatNotIn(List<Integer> values) {
            addCriterion("proc_exec_stat not in", values, "procExecStat");
            return (Criteria) this;
        }

        public Criteria andProcExecStatBetween(Integer value1, Integer value2) {
            addCriterion("proc_exec_stat between", value1, value2, "procExecStat");
            return (Criteria) this;
        }

        public Criteria andProcExecStatNotBetween(Integer value1, Integer value2) {
            addCriterion("proc_exec_stat not between", value1, value2, "procExecStat");
            return (Criteria) this;
        }

        public Criteria andOpeStatIsNull() {
            addCriterion("ope_stat is null");
            return (Criteria) this;
        }

        public Criteria andOpeStatIsNotNull() {
            addCriterion("ope_stat is not null");
            return (Criteria) this;
        }

        public Criteria andOpeStatEqualTo(Integer value) {
            addCriterion("ope_stat =", value, "opeStat");
            return (Criteria) this;
        }

        public Criteria andOpeStatNotEqualTo(Integer value) {
            addCriterion("ope_stat <>", value, "opeStat");
            return (Criteria) this;
        }

        public Criteria andOpeStatGreaterThan(Integer value) {
            addCriterion("ope_stat >", value, "opeStat");
            return (Criteria) this;
        }

        public Criteria andOpeStatGreaterThanOrEqualTo(Integer value) {
            addCriterion("ope_stat >=", value, "opeStat");
            return (Criteria) this;
        }

        public Criteria andOpeStatLessThan(Integer value) {
            addCriterion("ope_stat <", value, "opeStat");
            return (Criteria) this;
        }

        public Criteria andOpeStatLessThanOrEqualTo(Integer value) {
            addCriterion("ope_stat <=", value, "opeStat");
            return (Criteria) this;
        }

        public Criteria andOpeStatIn(List<Integer> values) {
            addCriterion("ope_stat in", values, "opeStat");
            return (Criteria) this;
        }

        public Criteria andOpeStatNotIn(List<Integer> values) {
            addCriterion("ope_stat not in", values, "opeStat");
            return (Criteria) this;
        }

        public Criteria andOpeStatBetween(Integer value1, Integer value2) {
            addCriterion("ope_stat between", value1, value2, "opeStat");
            return (Criteria) this;
        }

        public Criteria andOpeStatNotBetween(Integer value1, Integer value2) {
            addCriterion("ope_stat not between", value1, value2, "opeStat");
            return (Criteria) this;
        }

        public Criteria andOpeStatFlagIsNull() {
            addCriterion("ope_stat_flag is null");
            return (Criteria) this;
        }

        public Criteria andOpeStatFlagIsNotNull() {
            addCriterion("ope_stat_flag is not null");
            return (Criteria) this;
        }

        public Criteria andOpeStatFlagEqualTo(Integer value) {
            addCriterion("ope_stat_flag =", value, "opeStatFlag");
            return (Criteria) this;
        }

        public Criteria andOpeStatFlagNotEqualTo(Integer value) {
            addCriterion("ope_stat_flag <>", value, "opeStatFlag");
            return (Criteria) this;
        }

        public Criteria andOpeStatFlagGreaterThan(Integer value) {
            addCriterion("ope_stat_flag >", value, "opeStatFlag");
            return (Criteria) this;
        }

        public Criteria andOpeStatFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("ope_stat_flag >=", value, "opeStatFlag");
            return (Criteria) this;
        }

        public Criteria andOpeStatFlagLessThan(Integer value) {
            addCriterion("ope_stat_flag <", value, "opeStatFlag");
            return (Criteria) this;
        }

        public Criteria andOpeStatFlagLessThanOrEqualTo(Integer value) {
            addCriterion("ope_stat_flag <=", value, "opeStatFlag");
            return (Criteria) this;
        }

        public Criteria andOpeStatFlagIn(List<Integer> values) {
            addCriterion("ope_stat_flag in", values, "opeStatFlag");
            return (Criteria) this;
        }

        public Criteria andOpeStatFlagNotIn(List<Integer> values) {
            addCriterion("ope_stat_flag not in", values, "opeStatFlag");
            return (Criteria) this;
        }

        public Criteria andOpeStatFlagBetween(Integer value1, Integer value2) {
            addCriterion("ope_stat_flag between", value1, value2, "opeStatFlag");
            return (Criteria) this;
        }

        public Criteria andOpeStatFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("ope_stat_flag not between", value1, value2, "opeStatFlag");
            return (Criteria) this;
        }

        public Criteria andOpeStatDtimeIsNull() {
            addCriterion("ope_stat_dtime is null");
            return (Criteria) this;
        }

        public Criteria andOpeStatDtimeIsNotNull() {
            addCriterion("ope_stat_dtime is not null");
            return (Criteria) this;
        }

        public Criteria andOpeStatDtimeEqualTo(Date value) {
            addCriterionForJDBCDate("ope_stat_dtime =", value, "opeStatDtime");
            return (Criteria) this;
        }

        public Criteria andOpeStatDtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ope_stat_dtime <>", value, "opeStatDtime");
            return (Criteria) this;
        }

        public Criteria andOpeStatDtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ope_stat_dtime >", value, "opeStatDtime");
            return (Criteria) this;
        }

        public Criteria andOpeStatDtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ope_stat_dtime >=", value, "opeStatDtime");
            return (Criteria) this;
        }

        public Criteria andOpeStatDtimeLessThan(Date value) {
            addCriterionForJDBCDate("ope_stat_dtime <", value, "opeStatDtime");
            return (Criteria) this;
        }

        public Criteria andOpeStatDtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ope_stat_dtime <=", value, "opeStatDtime");
            return (Criteria) this;
        }

        public Criteria andOpeStatDtimeIn(List<Date> values) {
            addCriterionForJDBCDate("ope_stat_dtime in", values, "opeStatDtime");
            return (Criteria) this;
        }

        public Criteria andOpeStatDtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ope_stat_dtime not in", values, "opeStatDtime");
            return (Criteria) this;
        }

        public Criteria andOpeStatDtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ope_stat_dtime between", value1, value2, "opeStatDtime");
            return (Criteria) this;
        }

        public Criteria andOpeStatDtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ope_stat_dtime not between", value1, value2, "opeStatDtime");
            return (Criteria) this;
        }

        public Criteria andApStatIsNull() {
            addCriterion("ap_stat is null");
            return (Criteria) this;
        }

        public Criteria andApStatIsNotNull() {
            addCriterion("ap_stat is not null");
            return (Criteria) this;
        }

        public Criteria andApStatEqualTo(Integer value) {
            addCriterion("ap_stat =", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatNotEqualTo(Integer value) {
            addCriterion("ap_stat <>", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatGreaterThan(Integer value) {
            addCriterion("ap_stat >", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatGreaterThanOrEqualTo(Integer value) {
            addCriterion("ap_stat >=", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatLessThan(Integer value) {
            addCriterion("ap_stat <", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatLessThanOrEqualTo(Integer value) {
            addCriterion("ap_stat <=", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatIn(List<Integer> values) {
            addCriterion("ap_stat in", values, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatNotIn(List<Integer> values) {
            addCriterion("ap_stat not in", values, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatBetween(Integer value1, Integer value2) {
            addCriterion("ap_stat between", value1, value2, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatNotBetween(Integer value1, Integer value2) {
            addCriterion("ap_stat not between", value1, value2, "apStat");
            return (Criteria) this;
        }

        public Criteria andOpcServerStatIsNull() {
            addCriterion("opc_server_stat is null");
            return (Criteria) this;
        }

        public Criteria andOpcServerStatIsNotNull() {
            addCriterion("opc_server_stat is not null");
            return (Criteria) this;
        }

        public Criteria andOpcServerStatEqualTo(Integer value) {
            addCriterion("opc_server_stat =", value, "opcServerStat");
            return (Criteria) this;
        }

        public Criteria andOpcServerStatNotEqualTo(Integer value) {
            addCriterion("opc_server_stat <>", value, "opcServerStat");
            return (Criteria) this;
        }

        public Criteria andOpcServerStatGreaterThan(Integer value) {
            addCriterion("opc_server_stat >", value, "opcServerStat");
            return (Criteria) this;
        }

        public Criteria andOpcServerStatGreaterThanOrEqualTo(Integer value) {
            addCriterion("opc_server_stat >=", value, "opcServerStat");
            return (Criteria) this;
        }

        public Criteria andOpcServerStatLessThan(Integer value) {
            addCriterion("opc_server_stat <", value, "opcServerStat");
            return (Criteria) this;
        }

        public Criteria andOpcServerStatLessThanOrEqualTo(Integer value) {
            addCriterion("opc_server_stat <=", value, "opcServerStat");
            return (Criteria) this;
        }

        public Criteria andOpcServerStatIn(List<Integer> values) {
            addCriterion("opc_server_stat in", values, "opcServerStat");
            return (Criteria) this;
        }

        public Criteria andOpcServerStatNotIn(List<Integer> values) {
            addCriterion("opc_server_stat not in", values, "opcServerStat");
            return (Criteria) this;
        }

        public Criteria andOpcServerStatBetween(Integer value1, Integer value2) {
            addCriterion("opc_server_stat between", value1, value2, "opcServerStat");
            return (Criteria) this;
        }

        public Criteria andOpcServerStatNotBetween(Integer value1, Integer value2) {
            addCriterion("opc_server_stat not between", value1, value2, "opcServerStat");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserIsNull() {
            addCriterion("last_upd_user is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserIsNotNull() {
            addCriterion("last_upd_user is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserEqualTo(String value) {
            addCriterion("last_upd_user =", value, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserNotEqualTo(String value) {
            addCriterion("last_upd_user <>", value, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserGreaterThan(String value) {
            addCriterion("last_upd_user >", value, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserGreaterThanOrEqualTo(String value) {
            addCriterion("last_upd_user >=", value, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserLessThan(String value) {
            addCriterion("last_upd_user <", value, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserLessThanOrEqualTo(String value) {
            addCriterion("last_upd_user <=", value, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserLike(String value) {
            addCriterion("last_upd_user like", value, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserNotLike(String value) {
            addCriterion("last_upd_user not like", value, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserIn(List<String> values) {
            addCriterion("last_upd_user in", values, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserNotIn(List<String> values) {
            addCriterion("last_upd_user not in", values, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserBetween(String value1, String value2) {
            addCriterion("last_upd_user between", value1, value2, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserNotBetween(String value1, String value2) {
            addCriterion("last_upd_user not between", value1, value2, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeIsNull() {
            addCriterion("last_upd_dtime is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeIsNotNull() {
            addCriterion("last_upd_dtime is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeEqualTo(Date value) {
            addCriterionForJDBCDate("last_upd_dtime =", value, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("last_upd_dtime <>", value, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("last_upd_dtime >", value, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("last_upd_dtime >=", value, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeLessThan(Date value) {
            addCriterionForJDBCDate("last_upd_dtime <", value, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("last_upd_dtime <=", value, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeIn(List<Date> values) {
            addCriterionForJDBCDate("last_upd_dtime in", values, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("last_upd_dtime not in", values, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("last_upd_dtime between", value1, value2, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("last_upd_dtime not between", value1, value2, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Integer value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Integer value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Integer value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Integer value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Integer value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Integer> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Integer> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.cmt_system_stat
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.cmt_system_stat
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}