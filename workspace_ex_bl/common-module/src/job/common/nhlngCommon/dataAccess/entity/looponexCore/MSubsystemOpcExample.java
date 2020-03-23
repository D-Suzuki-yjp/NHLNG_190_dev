package job.common.nhlngCommon.dataAccess.entity.looponexCore;

import java.util.ArrayList;
import java.util.List;

public class MSubsystemOpcExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.m_subsystem_opc
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.m_subsystem_opc
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.m_subsystem_opc
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem_opc
     *
     * @mbg.generated
     */
    public MSubsystemOpcExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem_opc
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem_opc
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem_opc
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem_opc
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem_opc
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem_opc
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem_opc
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
     * This method corresponds to the database table public.m_subsystem_opc
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem_opc
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.m_subsystem_opc
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
     * This class corresponds to the database table public.m_subsystem_opc
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

        public Criteria andSubsystemIdIsNull() {
            addCriterion("subsystem_id is null");
            return (Criteria) this;
        }

        public Criteria andSubsystemIdIsNotNull() {
            addCriterion("subsystem_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubsystemIdEqualTo(String value) {
            addCriterion("subsystem_id =", value, "subsystemId");
            return (Criteria) this;
        }

        public Criteria andSubsystemIdNotEqualTo(String value) {
            addCriterion("subsystem_id <>", value, "subsystemId");
            return (Criteria) this;
        }

        public Criteria andSubsystemIdGreaterThan(String value) {
            addCriterion("subsystem_id >", value, "subsystemId");
            return (Criteria) this;
        }

        public Criteria andSubsystemIdGreaterThanOrEqualTo(String value) {
            addCriterion("subsystem_id >=", value, "subsystemId");
            return (Criteria) this;
        }

        public Criteria andSubsystemIdLessThan(String value) {
            addCriterion("subsystem_id <", value, "subsystemId");
            return (Criteria) this;
        }

        public Criteria andSubsystemIdLessThanOrEqualTo(String value) {
            addCriterion("subsystem_id <=", value, "subsystemId");
            return (Criteria) this;
        }

        public Criteria andSubsystemIdLike(String value) {
            addCriterion("subsystem_id like", value, "subsystemId");
            return (Criteria) this;
        }

        public Criteria andSubsystemIdNotLike(String value) {
            addCriterion("subsystem_id not like", value, "subsystemId");
            return (Criteria) this;
        }

        public Criteria andSubsystemIdIn(List<String> values) {
            addCriterion("subsystem_id in", values, "subsystemId");
            return (Criteria) this;
        }

        public Criteria andSubsystemIdNotIn(List<String> values) {
            addCriterion("subsystem_id not in", values, "subsystemId");
            return (Criteria) this;
        }

        public Criteria andSubsystemIdBetween(String value1, String value2) {
            addCriterion("subsystem_id between", value1, value2, "subsystemId");
            return (Criteria) this;
        }

        public Criteria andSubsystemIdNotBetween(String value1, String value2) {
            addCriterion("subsystem_id not between", value1, value2, "subsystemId");
            return (Criteria) this;
        }

        public Criteria andExOpcNameIsNull() {
            addCriterion("ex_opc_name is null");
            return (Criteria) this;
        }

        public Criteria andExOpcNameIsNotNull() {
            addCriterion("ex_opc_name is not null");
            return (Criteria) this;
        }

        public Criteria andExOpcNameEqualTo(String value) {
            addCriterion("ex_opc_name =", value, "exOpcName");
            return (Criteria) this;
        }

        public Criteria andExOpcNameNotEqualTo(String value) {
            addCriterion("ex_opc_name <>", value, "exOpcName");
            return (Criteria) this;
        }

        public Criteria andExOpcNameGreaterThan(String value) {
            addCriterion("ex_opc_name >", value, "exOpcName");
            return (Criteria) this;
        }

        public Criteria andExOpcNameGreaterThanOrEqualTo(String value) {
            addCriterion("ex_opc_name >=", value, "exOpcName");
            return (Criteria) this;
        }

        public Criteria andExOpcNameLessThan(String value) {
            addCriterion("ex_opc_name <", value, "exOpcName");
            return (Criteria) this;
        }

        public Criteria andExOpcNameLessThanOrEqualTo(String value) {
            addCriterion("ex_opc_name <=", value, "exOpcName");
            return (Criteria) this;
        }

        public Criteria andExOpcNameLike(String value) {
            addCriterion("ex_opc_name like", value, "exOpcName");
            return (Criteria) this;
        }

        public Criteria andExOpcNameNotLike(String value) {
            addCriterion("ex_opc_name not like", value, "exOpcName");
            return (Criteria) this;
        }

        public Criteria andExOpcNameIn(List<String> values) {
            addCriterion("ex_opc_name in", values, "exOpcName");
            return (Criteria) this;
        }

        public Criteria andExOpcNameNotIn(List<String> values) {
            addCriterion("ex_opc_name not in", values, "exOpcName");
            return (Criteria) this;
        }

        public Criteria andExOpcNameBetween(String value1, String value2) {
            addCriterion("ex_opc_name between", value1, value2, "exOpcName");
            return (Criteria) this;
        }

        public Criteria andExOpcNameNotBetween(String value1, String value2) {
            addCriterion("ex_opc_name not between", value1, value2, "exOpcName");
            return (Criteria) this;
        }

        public Criteria andExOpcPortIsNull() {
            addCriterion("ex_opc_port is null");
            return (Criteria) this;
        }

        public Criteria andExOpcPortIsNotNull() {
            addCriterion("ex_opc_port is not null");
            return (Criteria) this;
        }

        public Criteria andExOpcPortEqualTo(Integer value) {
            addCriterion("ex_opc_port =", value, "exOpcPort");
            return (Criteria) this;
        }

        public Criteria andExOpcPortNotEqualTo(Integer value) {
            addCriterion("ex_opc_port <>", value, "exOpcPort");
            return (Criteria) this;
        }

        public Criteria andExOpcPortGreaterThan(Integer value) {
            addCriterion("ex_opc_port >", value, "exOpcPort");
            return (Criteria) this;
        }

        public Criteria andExOpcPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("ex_opc_port >=", value, "exOpcPort");
            return (Criteria) this;
        }

        public Criteria andExOpcPortLessThan(Integer value) {
            addCriterion("ex_opc_port <", value, "exOpcPort");
            return (Criteria) this;
        }

        public Criteria andExOpcPortLessThanOrEqualTo(Integer value) {
            addCriterion("ex_opc_port <=", value, "exOpcPort");
            return (Criteria) this;
        }

        public Criteria andExOpcPortIn(List<Integer> values) {
            addCriterion("ex_opc_port in", values, "exOpcPort");
            return (Criteria) this;
        }

        public Criteria andExOpcPortNotIn(List<Integer> values) {
            addCriterion("ex_opc_port not in", values, "exOpcPort");
            return (Criteria) this;
        }

        public Criteria andExOpcPortBetween(Integer value1, Integer value2) {
            addCriterion("ex_opc_port between", value1, value2, "exOpcPort");
            return (Criteria) this;
        }

        public Criteria andExOpcPortNotBetween(Integer value1, Integer value2) {
            addCriterion("ex_opc_port not between", value1, value2, "exOpcPort");
            return (Criteria) this;
        }

        public Criteria andExOpcDaProgidIsNull() {
            addCriterion("ex_opc_da_progid is null");
            return (Criteria) this;
        }

        public Criteria andExOpcDaProgidIsNotNull() {
            addCriterion("ex_opc_da_progid is not null");
            return (Criteria) this;
        }

        public Criteria andExOpcDaProgidEqualTo(String value) {
            addCriterion("ex_opc_da_progid =", value, "exOpcDaProgid");
            return (Criteria) this;
        }

        public Criteria andExOpcDaProgidNotEqualTo(String value) {
            addCriterion("ex_opc_da_progid <>", value, "exOpcDaProgid");
            return (Criteria) this;
        }

        public Criteria andExOpcDaProgidGreaterThan(String value) {
            addCriterion("ex_opc_da_progid >", value, "exOpcDaProgid");
            return (Criteria) this;
        }

        public Criteria andExOpcDaProgidGreaterThanOrEqualTo(String value) {
            addCriterion("ex_opc_da_progid >=", value, "exOpcDaProgid");
            return (Criteria) this;
        }

        public Criteria andExOpcDaProgidLessThan(String value) {
            addCriterion("ex_opc_da_progid <", value, "exOpcDaProgid");
            return (Criteria) this;
        }

        public Criteria andExOpcDaProgidLessThanOrEqualTo(String value) {
            addCriterion("ex_opc_da_progid <=", value, "exOpcDaProgid");
            return (Criteria) this;
        }

        public Criteria andExOpcDaProgidLike(String value) {
            addCriterion("ex_opc_da_progid like", value, "exOpcDaProgid");
            return (Criteria) this;
        }

        public Criteria andExOpcDaProgidNotLike(String value) {
            addCriterion("ex_opc_da_progid not like", value, "exOpcDaProgid");
            return (Criteria) this;
        }

        public Criteria andExOpcDaProgidIn(List<String> values) {
            addCriterion("ex_opc_da_progid in", values, "exOpcDaProgid");
            return (Criteria) this;
        }

        public Criteria andExOpcDaProgidNotIn(List<String> values) {
            addCriterion("ex_opc_da_progid not in", values, "exOpcDaProgid");
            return (Criteria) this;
        }

        public Criteria andExOpcDaProgidBetween(String value1, String value2) {
            addCriterion("ex_opc_da_progid between", value1, value2, "exOpcDaProgid");
            return (Criteria) this;
        }

        public Criteria andExOpcDaProgidNotBetween(String value1, String value2) {
            addCriterion("ex_opc_da_progid not between", value1, value2, "exOpcDaProgid");
            return (Criteria) this;
        }

        public Criteria andServerAddressIsNull() {
            addCriterion("server_address is null");
            return (Criteria) this;
        }

        public Criteria andServerAddressIsNotNull() {
            addCriterion("server_address is not null");
            return (Criteria) this;
        }

        public Criteria andServerAddressEqualTo(String value) {
            addCriterion("server_address =", value, "serverAddress");
            return (Criteria) this;
        }

        public Criteria andServerAddressNotEqualTo(String value) {
            addCriterion("server_address <>", value, "serverAddress");
            return (Criteria) this;
        }

        public Criteria andServerAddressGreaterThan(String value) {
            addCriterion("server_address >", value, "serverAddress");
            return (Criteria) this;
        }

        public Criteria andServerAddressGreaterThanOrEqualTo(String value) {
            addCriterion("server_address >=", value, "serverAddress");
            return (Criteria) this;
        }

        public Criteria andServerAddressLessThan(String value) {
            addCriterion("server_address <", value, "serverAddress");
            return (Criteria) this;
        }

        public Criteria andServerAddressLessThanOrEqualTo(String value) {
            addCriterion("server_address <=", value, "serverAddress");
            return (Criteria) this;
        }

        public Criteria andServerAddressLike(String value) {
            addCriterion("server_address like", value, "serverAddress");
            return (Criteria) this;
        }

        public Criteria andServerAddressNotLike(String value) {
            addCriterion("server_address not like", value, "serverAddress");
            return (Criteria) this;
        }

        public Criteria andServerAddressIn(List<String> values) {
            addCriterion("server_address in", values, "serverAddress");
            return (Criteria) this;
        }

        public Criteria andServerAddressNotIn(List<String> values) {
            addCriterion("server_address not in", values, "serverAddress");
            return (Criteria) this;
        }

        public Criteria andServerAddressBetween(String value1, String value2) {
            addCriterion("server_address between", value1, value2, "serverAddress");
            return (Criteria) this;
        }

        public Criteria andServerAddressNotBetween(String value1, String value2) {
            addCriterion("server_address not between", value1, value2, "serverAddress");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.m_subsystem_opc
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
     * This class corresponds to the database table public.m_subsystem_opc
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