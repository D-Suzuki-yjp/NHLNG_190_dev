package job.sfcommon.dataaccess.entity.nhlng;

import java.util.ArrayList;
import java.util.List;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/04/01 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmTagMasterV NHタグマスタ(ビュー)entityExample
 * ジェネレータがviewからは生成しないので手動作成
 * @author D.Suzuki
 */
import javax.enterprise.context.Dependent;

@Dependent
public class CmmTagMasterVExample {

    protected String orderByClause;

    protected boolean distinct;


    protected List<Criteria> oredCriteria;

    protected Criteria criteria;

    public CmmTagMasterVExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

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

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andTagNoIsNull() {
            addCriterion("tag_no is null");
            return (Criteria) this;
        }

        public Criteria andTagNoIsNotNull() {
            addCriterion("tag_no is not null");
            return (Criteria) this;
        }

        public Criteria andTagNoEqualTo(String value) {
            addCriterion("tag_no =", value, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoNotEqualTo(String value) {
            addCriterion("tag_no <>", value, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoGreaterThan(String value) {
            addCriterion("tag_no >", value, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoGreaterThanOrEqualTo(String value) {
            addCriterion("tag_no >=", value, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoLessThan(String value) {
            addCriterion("tag_no <", value, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoLessThanOrEqualTo(String value) {
            addCriterion("tag_no <=", value, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoLike(String value) {
            addCriterion("tag_no like", value, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoNotLike(String value) {
            addCriterion("tag_no not like", value, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoIn(List<String> values) {
            addCriterion("tag_no in", values, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoNotIn(List<String> values) {
            addCriterion("tag_no not in", values, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoBetween(String value1, String value2) {
            addCriterion("tag_no between", value1, value2, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoNotBetween(String value1, String value2) {
            addCriterion("tag_no not between", value1, value2, "tagNo");
            return (Criteria) this;
        }

        public Criteria andLcodeIsNull() {
            addCriterion("lcode is null");
            return (Criteria) this;
        }

        public Criteria andLcodeIsNotNull() {
            addCriterion("lcode is not null");
            return (Criteria) this;
        }

        public Criteria andLcodeEqualTo(String value) {
            addCriterion("lcode =", value, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeNotEqualTo(String value) {
            addCriterion("lcode <>", value, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeGreaterThan(String value) {
            addCriterion("lcode >", value, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeGreaterThanOrEqualTo(String value) {
            addCriterion("lcode >=", value, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeLessThan(String value) {
            addCriterion("lcode <", value, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeLessThanOrEqualTo(String value) {
            addCriterion("lcode <=", value, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeLike(String value) {
            addCriterion("lcode like", value, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeNotLike(String value) {
            addCriterion("lcode not like", value, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeIn(List<String> values) {
            addCriterion("lcode in", values, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeNotIn(List<String> values) {
            addCriterion("lcode not in", values, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeBetween(String value1, String value2) {
            addCriterion("lcode between", value1, value2, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeNotBetween(String value1, String value2) {
            addCriterion("lcode not between", value1, value2, "lcode");
            return (Criteria) this;
        }

        public Criteria andComment1IsNull() {
            addCriterion("comment1 is null");
            return (Criteria) this;
        }

        public Criteria andComment1IsNotNull() {
            addCriterion("comment1 is not null");
            return (Criteria) this;
        }

        public Criteria andComment1EqualTo(String value) {
            addCriterion("comment1 =", value, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1NotEqualTo(String value) {
            addCriterion("comment1 <>", value, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1GreaterThan(String value) {
            addCriterion("comment1 >", value, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1GreaterThanOrEqualTo(String value) {
            addCriterion("comment1 >=", value, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1LessThan(String value) {
            addCriterion("comment1 <", value, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1LessThanOrEqualTo(String value) {
            addCriterion("comment1 <=", value, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1Like(String value) {
            addCriterion("comment1 like", value, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1NotLike(String value) {
            addCriterion("comment1 not like", value, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1In(List<String> values) {
            addCriterion("comment1 in", values, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1NotIn(List<String> values) {
            addCriterion("comment1 not in", values, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1Between(String value1, String value2) {
            addCriterion("comment1 between", value1, value2, "comment1");
            return (Criteria) this;
        }

        public Criteria andComment1NotBetween(String value1, String value2) {
            addCriterion("comment1 not between", value1, value2, "comment1");
            return (Criteria) this;
        }

        public Criteria andUnitComputerIsNull() {
            addCriterion("unit_computer is null");
            return (Criteria) this;
        }

        public Criteria andUnitComputerIsNotNull() {
            addCriterion("unit_computer is not null");
            return (Criteria) this;
        }

        public Criteria andUnitComputerEqualTo(String value) {
            addCriterion("unit_computer =", value, "unitComputer");
            return (Criteria) this;
        }

        public Criteria andUnitComputerNotEqualTo(String value) {
            addCriterion("unit_computer <>", value, "unitComputer");
            return (Criteria) this;
        }

        public Criteria andUnitComputerGreaterThan(String value) {
            addCriterion("unit_computer >", value, "unitComputer");
            return (Criteria) this;
        }

        public Criteria andUnitComputerGreaterThanOrEqualTo(String value) {
            addCriterion("unit_computer >=", value, "unitComputer");
            return (Criteria) this;
        }

        public Criteria andUnitComputerLessThan(String value) {
            addCriterion("unit_computer <", value, "unitComputer");
            return (Criteria) this;
        }

        public Criteria andUnitComputerLessThanOrEqualTo(String value) {
            addCriterion("unit_computer <=", value, "unitComputer");
            return (Criteria) this;
        }

        public Criteria andUnitComputerLike(String value) {
            addCriterion("unit_computer like", value, "unitComputer");
            return (Criteria) this;
        }

        public Criteria andUnitComputerNotLike(String value) {
            addCriterion("unit_computer not like", value, "unitComputer");
            return (Criteria) this;
        }

        public Criteria andUnitComputerIn(List<String> values) {
            addCriterion("unit_computer in", values, "unitComputer");
            return (Criteria) this;
        }

        public Criteria andUnitComputerNotIn(List<String> values) {
            addCriterion("unit_computer not in", values, "unitComputer");
            return (Criteria) this;
        }

        public Criteria andUnitComputerBetween(String value1, String value2) {
            addCriterion("unit_computer between", value1, value2, "unitComputer");
            return (Criteria) this;
        }

        public Criteria andUnitComputerNotBetween(String value1, String value2) {
            addCriterion("unit_computer not between", value1, value2, "unitComputer");
            return (Criteria) this;
        }

        public Criteria andDpIsNull() {
            addCriterion("dp is null");
            return (Criteria) this;
        }

        public Criteria andDpIsNotNull() {
            addCriterion("dp is not null");
            return (Criteria) this;
        }

        public Criteria andDpEqualTo(Integer value) {
            addCriterion("dp =", value, "dp");
            return (Criteria) this;
        }

        public Criteria andDpNotEqualTo(Integer value) {
            addCriterion("dp <>", value, "dp");
            return (Criteria) this;
        }

        public Criteria andDpGreaterThan(Integer value) {
            addCriterion("dp >", value, "dp");
            return (Criteria) this;
        }

        public Criteria andDpGreaterThanOrEqualTo(Integer value) {
            addCriterion("dp >=", value, "dp");
            return (Criteria) this;
        }

        public Criteria andDpLessThan(Integer value) {
            addCriterion("dp <", value, "dp");
            return (Criteria) this;
        }

        public Criteria andDpLessThanOrEqualTo(Integer value) {
            addCriterion("dp <=", value, "dp");
            return (Criteria) this;
        }

        public Criteria andDpIn(List<Integer> values) {
            addCriterion("dp in", values, "dp");
            return (Criteria) this;
        }

        public Criteria andDpNotIn(List<Integer> values) {
            addCriterion("dp not in", values, "dp");
            return (Criteria) this;
        }

        public Criteria andDpBetween(Integer value1, Integer value2) {
            addCriterion("dp between", value1, value2, "dp");
            return (Criteria) this;
        }

        public Criteria andDpNotBetween(Integer value1, Integer value2) {
            addCriterion("dp not between", value1, value2, "dp");
            return (Criteria) this;
        }

        public Criteria andUpperValueIsNull() {
            addCriterion("upper_value is null");
            return (Criteria) this;
        }

        public Criteria andUpperValueIsNotNull() {
            addCriterion("upper_value is not null");
            return (Criteria) this;
        }

        public Criteria andUpperValueEqualTo(Float value) {
            addCriterion("upper_value =", value, "upperValue");
            return (Criteria) this;
        }

        public Criteria andUpperValueNotEqualTo(Float value) {
            addCriterion("upper_value <>", value, "upperValue");
            return (Criteria) this;
        }

        public Criteria andUpperValueGreaterThan(Float value) {
            addCriterion("upper_value >", value, "upperValue");
            return (Criteria) this;
        }

        public Criteria andUpperValueGreaterThanOrEqualTo(Float value) {
            addCriterion("upper_value >=", value, "upperValue");
            return (Criteria) this;
        }

        public Criteria andUpperValueLessThan(Float value) {
            addCriterion("upper_value <", value, "upperValue");
            return (Criteria) this;
        }

        public Criteria andUpperValueLessThanOrEqualTo(Float value) {
            addCriterion("upper_value <=", value, "upperValue");
            return (Criteria) this;
        }

        public Criteria andUpperValueIn(List<Float> values) {
            addCriterion("upper_value in", values, "upperValue");
            return (Criteria) this;
        }

        public Criteria andUpperValueNotIn(List<Float> values) {
            addCriterion("upper_value not in", values, "upperValue");
            return (Criteria) this;
        }

        public Criteria andUpperValueBetween(Float value1, Float value2) {
            addCriterion("upper_value between", value1, value2, "upperValue");
            return (Criteria) this;
        }

        public Criteria andUpperValueNotBetween(Float value1, Float value2) {
            addCriterion("upper_value not between", value1, value2, "upperValue");
            return (Criteria) this;
        }

        public Criteria andLowerValueIsNull() {
            addCriterion("lower_value is null");
            return (Criteria) this;
        }

        public Criteria andLowerValueIsNotNull() {
            addCriterion("lower_value is not null");
            return (Criteria) this;
        }

        public Criteria andLowerValueEqualTo(Float value) {
            addCriterion("lower_value =", value, "lowerValue");
            return (Criteria) this;
        }

        public Criteria andLowerValueNotEqualTo(Float value) {
            addCriterion("lower_value <>", value, "lowerValue");
            return (Criteria) this;
        }

        public Criteria andLowerValueGreaterThan(Float value) {
            addCriterion("lower_value >", value, "lowerValue");
            return (Criteria) this;
        }

        public Criteria andLowerValueGreaterThanOrEqualTo(Float value) {
            addCriterion("lower_value >=", value, "lowerValue");
            return (Criteria) this;
        }

        public Criteria andLowerValueLessThan(Float value) {
            addCriterion("lower_value <", value, "lowerValue");
            return (Criteria) this;
        }

        public Criteria andLowerValueLessThanOrEqualTo(Float value) {
            addCriterion("lower_value <=", value, "lowerValue");
            return (Criteria) this;
        }

        public Criteria andLowerValueIn(List<Float> values) {
            addCriterion("lower_value in", values, "lowerValue");
            return (Criteria) this;
        }

        public Criteria andLowerValueNotIn(List<Float> values) {
            addCriterion("lower_value not in", values, "lowerValue");
            return (Criteria) this;
        }

        public Criteria andLowerValueBetween(Float value1, Float value2) {
            addCriterion("lower_value between", value1, value2, "lowerValue");
            return (Criteria) this;
        }

        public Criteria andLowerValueNotBetween(Float value1, Float value2) {
            addCriterion("lower_value not between", value1, value2, "lowerValue");
            return (Criteria) this;
        }

        public Criteria andTagKindIsNull() {
            addCriterion("tag_kind is null");
            return (Criteria) this;
        }

        public Criteria andTagKindIsNotNull() {
            addCriterion("tag_kind is not null");
            return (Criteria) this;
        }

        public Criteria andTagKindEqualTo(Integer value) {
            addCriterion("tag_kind =", value, "tagKind");
            return (Criteria) this;
        }

        public Criteria andTagKindNotEqualTo(Integer value) {
            addCriterion("tag_kind <>", value, "tagKind");
            return (Criteria) this;
        }

        public Criteria andTagKindGreaterThan(Integer value) {
            addCriterion("tag_kind >", value, "tagKind");
            return (Criteria) this;
        }

        public Criteria andTagKindGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag_kind >=", value, "tagKind");
            return (Criteria) this;
        }

        public Criteria andTagKindLessThan(Integer value) {
            addCriterion("tag_kind <", value, "tagKind");
            return (Criteria) this;
        }

        public Criteria andTagKindLessThanOrEqualTo(Integer value) {
            addCriterion("tag_kind <=", value, "tagKind");
            return (Criteria) this;
        }

        public Criteria andTagKindIn(List<Integer> values) {
            addCriterion("tag_kind in", values, "tagKind");
            return (Criteria) this;
        }

        public Criteria andTagKindNotIn(List<Integer> values) {
            addCriterion("tag_kind not in", values, "tagKind");
            return (Criteria) this;
        }

        public Criteria andTagKindBetween(Integer value1, Integer value2) {
            addCriterion("tag_kind between", value1, value2, "tagKind");
            return (Criteria) this;
        }

        public Criteria andTagKindNotBetween(Integer value1, Integer value2) {
            addCriterion("tag_kind not between", value1, value2, "tagKind");
            return (Criteria) this;
        }

        public Criteria andIoKindIsNull() {
            addCriterion("io_kind is null");
            return (Criteria) this;
        }

        public Criteria andIoKindIsNotNull() {
            addCriterion("io_kind is not null");
            return (Criteria) this;
        }

        public Criteria andIoKindEqualTo(String value) {
            addCriterion("io_kind =", value, "ioKind");
            return (Criteria) this;
        }

        public Criteria andIoKindNotEqualTo(String value) {
            addCriterion("io_kind <>", value, "ioKind");
            return (Criteria) this;
        }

        public Criteria andIoKindGreaterThan(String value) {
            addCriterion("io_kind >", value, "ioKind");
            return (Criteria) this;
        }

        public Criteria andIoKindGreaterThanOrEqualTo(String value) {
            addCriterion("io_kind >=", value, "ioKind");
            return (Criteria) this;
        }

        public Criteria andIoKindLessThan(String value) {
            addCriterion("io_kind <", value, "ioKind");
            return (Criteria) this;
        }

        public Criteria andIoKindLessThanOrEqualTo(String value) {
            addCriterion("io_kind <=", value, "ioKind");
            return (Criteria) this;
        }

        public Criteria andIoKindLike(String value) {
            addCriterion("io_kind like", value, "ioKind");
            return (Criteria) this;
        }

        public Criteria andIoKindNotLike(String value) {
            addCriterion("io_kind not like", value, "ioKind");
            return (Criteria) this;
        }

        public Criteria andIoKindIn(List<String> values) {
            addCriterion("io_kind in", values, "ioKind");
            return (Criteria) this;
        }

        public Criteria andIoKindNotIn(List<String> values) {
            addCriterion("io_kind not in", values, "ioKind");
            return (Criteria) this;
        }

        public Criteria andIoKindBetween(String value1, String value2) {
            addCriterion("io_kind between", value1, value2, "ioKind");
            return (Criteria) this;
        }

        public Criteria andIoKindNotBetween(String value1, String value2) {
            addCriterion("io_kind not between", value1, value2, "ioKind");
            return (Criteria) this;
        }

        public Criteria andConstDivIsNull() {
            addCriterion("const_div is null");
            return (Criteria) this;
        }

        public Criteria andConstDivIsNotNull() {
            addCriterion("const_div is not null");
            return (Criteria) this;
        }

        public Criteria andConstDivEqualTo(String value) {
            addCriterion("const_div =", value, "constDiv");
            return (Criteria) this;
        }

        public Criteria andConstDivNotEqualTo(String value) {
            addCriterion("const_div <>", value, "constDiv");
            return (Criteria) this;
        }

        public Criteria andConstDivGreaterThan(String value) {
            addCriterion("const_div >", value, "constDiv");
            return (Criteria) this;
        }

        public Criteria andConstDivGreaterThanOrEqualTo(String value) {
            addCriterion("const_div >=", value, "constDiv");
            return (Criteria) this;
        }

        public Criteria andConstDivLessThan(String value) {
            addCriterion("const_div <", value, "constDiv");
            return (Criteria) this;
        }

        public Criteria andConstDivLessThanOrEqualTo(String value) {
            addCriterion("const_div <=", value, "constDiv");
            return (Criteria) this;
        }

        public Criteria andConstDivLike(String value) {
            addCriterion("const_div like", value, "constDiv");
            return (Criteria) this;
        }

        public Criteria andConstDivNotLike(String value) {
            addCriterion("const_div not like", value, "constDiv");
            return (Criteria) this;
        }

        public Criteria andConstDivIn(List<String> values) {
            addCriterion("const_div in", values, "constDiv");
            return (Criteria) this;
        }

        public Criteria andConstDivNotIn(List<String> values) {
            addCriterion("const_div not in", values, "constDiv");
            return (Criteria) this;
        }

        public Criteria andConstDivBetween(String value1, String value2) {
            addCriterion("const_div between", value1, value2, "constDiv");
            return (Criteria) this;
        }

        public Criteria andConstDivNotBetween(String value1, String value2) {
            addCriterion("const_div not between", value1, value2, "constDiv");
            return (Criteria) this;
        }

        public Criteria andRepoDivIsNull() {
            addCriterion("repo_div is null");
            return (Criteria) this;
        }

        public Criteria andRepoDivIsNotNull() {
            addCriterion("repo_div is not null");
            return (Criteria) this;
        }

        public Criteria andRepoDivEqualTo(String value) {
            addCriterion("repo_div =", value, "repoDiv");
            return (Criteria) this;
        }

        public Criteria andRepoDivNotEqualTo(String value) {
            addCriterion("repo_div <>", value, "repoDiv");
            return (Criteria) this;
        }

        public Criteria andRepoDivGreaterThan(String value) {
            addCriterion("repo_div >", value, "repoDiv");
            return (Criteria) this;
        }

        public Criteria andRepoDivGreaterThanOrEqualTo(String value) {
            addCriterion("repo_div >=", value, "repoDiv");
            return (Criteria) this;
        }

        public Criteria andRepoDivLessThan(String value) {
            addCriterion("repo_div <", value, "repoDiv");
            return (Criteria) this;
        }

        public Criteria andRepoDivLessThanOrEqualTo(String value) {
            addCriterion("repo_div <=", value, "repoDiv");
            return (Criteria) this;
        }

        public Criteria andRepoDivLike(String value) {
            addCriterion("repo_div like", value, "repoDiv");
            return (Criteria) this;
        }

        public Criteria andRepoDivNotLike(String value) {
            addCriterion("repo_div not like", value, "repoDiv");
            return (Criteria) this;
        }

        public Criteria andRepoDivIn(List<String> values) {
            addCriterion("repo_div in", values, "repoDiv");
            return (Criteria) this;
        }

        public Criteria andRepoDivNotIn(List<String> values) {
            addCriterion("repo_div not in", values, "repoDiv");
            return (Criteria) this;
        }

        public Criteria andRepoDivBetween(String value1, String value2) {
            addCriterion("repo_div between", value1, value2, "repoDiv");
            return (Criteria) this;
        }

        public Criteria andRepoDivNotBetween(String value1, String value2) {
            addCriterion("repo_div not between", value1, value2, "repoDiv");
            return (Criteria) this;
        }

        public Criteria andRepoCalcDivIsNull() {
            addCriterion("repo_calc_div is null");
            return (Criteria) this;
        }

        public Criteria andRepoCalcDivIsNotNull() {
            addCriterion("repo_calc_div is not null");
            return (Criteria) this;
        }

        public Criteria andRepoCalcDivEqualTo(String value) {
            addCriterion("repo_calc_div =", value, "repoCalcDiv");
            return (Criteria) this;
        }

        public Criteria andRepoCalcDivNotEqualTo(String value) {
            addCriterion("repo_calc_div <>", value, "repoCalcDiv");
            return (Criteria) this;
        }

        public Criteria andRepoCalcDivGreaterThan(String value) {
            addCriterion("repo_calc_div >", value, "repoCalcDiv");
            return (Criteria) this;
        }

        public Criteria andRepoCalcDivGreaterThanOrEqualTo(String value) {
            addCriterion("repo_calc_div >=", value, "repoCalcDiv");
            return (Criteria) this;
        }

        public Criteria andRepoCalcDivLessThan(String value) {
            addCriterion("repo_calc_div <", value, "repoCalcDiv");
            return (Criteria) this;
        }

        public Criteria andRepoCalcDivLessThanOrEqualTo(String value) {
            addCriterion("repo_calc_div <=", value, "repoCalcDiv");
            return (Criteria) this;
        }

        public Criteria andRepoCalcDivLike(String value) {
            addCriterion("repo_calc_div like", value, "repoCalcDiv");
            return (Criteria) this;
        }

        public Criteria andRepoCalcDivNotLike(String value) {
            addCriterion("repo_calc_div not like", value, "repoCalcDiv");
            return (Criteria) this;
        }

        public Criteria andRepoCalcDivIn(List<String> values) {
            addCriterion("repo_calc_div in", values, "repoCalcDiv");
            return (Criteria) this;
        }

        public Criteria andRepoCalcDivNotIn(List<String> values) {
            addCriterion("repo_calc_div not in", values, "repoCalcDiv");
            return (Criteria) this;
        }

        public Criteria andRepoCalcDivBetween(String value1, String value2) {
            addCriterion("repo_calc_div between", value1, value2, "repoCalcDiv");
            return (Criteria) this;
        }

        public Criteria andRepoCalcDivNotBetween(String value1, String value2) {
            addCriterion("repo_calc_div not between", value1, value2, "repoCalcDiv");
            return (Criteria) this;
        }

        public Criteria andOdbMinSndFlagIsNull() {
            addCriterion("odb_min_snd_flag is null");
            return (Criteria) this;
        }

        public Criteria andOdbMinSndFlagIsNotNull() {
            addCriterion("odb_min_snd_flag is not null");
            return (Criteria) this;
        }

        public Criteria andOdbMinSndFlagEqualTo(Integer value) {
            addCriterion("odb_min_snd_flag =", value, "odbMinSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbMinSndFlagNotEqualTo(Integer value) {
            addCriterion("odb_min_snd_flag <>", value, "odbMinSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbMinSndFlagGreaterThan(Integer value) {
            addCriterion("odb_min_snd_flag >", value, "odbMinSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbMinSndFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("odb_min_snd_flag >=", value, "odbMinSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbMinSndFlagLessThan(Integer value) {
            addCriterion("odb_min_snd_flag <", value, "odbMinSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbMinSndFlagLessThanOrEqualTo(Integer value) {
            addCriterion("odb_min_snd_flag <=", value, "odbMinSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbMinSndFlagIn(List<Integer> values) {
            addCriterion("odb_min_snd_flag in", values, "odbMinSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbMinSndFlagNotIn(List<Integer> values) {
            addCriterion("odb_min_snd_flag not in", values, "odbMinSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbMinSndFlagBetween(Integer value1, Integer value2) {
            addCriterion("odb_min_snd_flag between", value1, value2, "odbMinSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbMinSndFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("odb_min_snd_flag not between", value1, value2, "odbMinSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbHourSndFlagIsNull() {
            addCriterion("odb_hour_snd_flag is null");
            return (Criteria) this;
        }

        public Criteria andOdbHourSndFlagIsNotNull() {
            addCriterion("odb_hour_snd_flag is not null");
            return (Criteria) this;
        }

        public Criteria andOdbHourSndFlagEqualTo(Integer value) {
            addCriterion("odb_hour_snd_flag =", value, "odbHourSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbHourSndFlagNotEqualTo(Integer value) {
            addCriterion("odb_hour_snd_flag <>", value, "odbHourSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbHourSndFlagGreaterThan(Integer value) {
            addCriterion("odb_hour_snd_flag >", value, "odbHourSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbHourSndFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("odb_hour_snd_flag >=", value, "odbHourSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbHourSndFlagLessThan(Integer value) {
            addCriterion("odb_hour_snd_flag <", value, "odbHourSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbHourSndFlagLessThanOrEqualTo(Integer value) {
            addCriterion("odb_hour_snd_flag <=", value, "odbHourSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbHourSndFlagIn(List<Integer> values) {
            addCriterion("odb_hour_snd_flag in", values, "odbHourSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbHourSndFlagNotIn(List<Integer> values) {
            addCriterion("odb_hour_snd_flag not in", values, "odbHourSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbHourSndFlagBetween(Integer value1, Integer value2) {
            addCriterion("odb_hour_snd_flag between", value1, value2, "odbHourSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbHourSndFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("odb_hour_snd_flag not between", value1, value2, "odbHourSndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbDaySndFlagIsNull() {
            addCriterion("odb_day_snd_flag is null");
            return (Criteria) this;
        }

        public Criteria andOdbDaySndFlagIsNotNull() {
            addCriterion("odb_day_snd_flag is not null");
            return (Criteria) this;
        }

        public Criteria andOdbDaySndFlagEqualTo(Integer value) {
            addCriterion("odb_day_snd_flag =", value, "odbDaySndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbDaySndFlagNotEqualTo(Integer value) {
            addCriterion("odb_day_snd_flag <>", value, "odbDaySndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbDaySndFlagGreaterThan(Integer value) {
            addCriterion("odb_day_snd_flag >", value, "odbDaySndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbDaySndFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("odb_day_snd_flag >=", value, "odbDaySndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbDaySndFlagLessThan(Integer value) {
            addCriterion("odb_day_snd_flag <", value, "odbDaySndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbDaySndFlagLessThanOrEqualTo(Integer value) {
            addCriterion("odb_day_snd_flag <=", value, "odbDaySndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbDaySndFlagIn(List<Integer> values) {
            addCriterion("odb_day_snd_flag in", values, "odbDaySndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbDaySndFlagNotIn(List<Integer> values) {
            addCriterion("odb_day_snd_flag not in", values, "odbDaySndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbDaySndFlagBetween(Integer value1, Integer value2) {
            addCriterion("odb_day_snd_flag between", value1, value2, "odbDaySndFlag");
            return (Criteria) this;
        }

        public Criteria andOdbDaySndFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("odb_day_snd_flag not between", value1, value2, "odbDaySndFlag");
            return (Criteria) this;
        }

        public Criteria andRoundFlagIsNull() {
            addCriterion("round_flag is null");
            return (Criteria) this;
        }

        public Criteria andRoundFlagIsNotNull() {
            addCriterion("round_flag is not null");
            return (Criteria) this;
        }

        public Criteria andRoundFlagEqualTo(Integer value) {
            addCriterion("round_flag =", value, "roundFlag");
            return (Criteria) this;
        }

        public Criteria andRoundFlagNotEqualTo(Integer value) {
            addCriterion("round_flag <>", value, "roundFlag");
            return (Criteria) this;
        }

        public Criteria andRoundFlagGreaterThan(Integer value) {
            addCriterion("round_flag >", value, "roundFlag");
            return (Criteria) this;
        }

        public Criteria andRoundFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("round_flag >=", value, "roundFlag");
            return (Criteria) this;
        }

        public Criteria andRoundFlagLessThan(Integer value) {
            addCriterion("round_flag <", value, "roundFlag");
            return (Criteria) this;
        }

        public Criteria andRoundFlagLessThanOrEqualTo(Integer value) {
            addCriterion("round_flag <=", value, "roundFlag");
            return (Criteria) this;
        }

        public Criteria andRoundFlagIn(List<Integer> values) {
            addCriterion("round_flag in", values, "roundFlag");
            return (Criteria) this;
        }

        public Criteria andRoundFlagNotIn(List<Integer> values) {
            addCriterion("round_flag not in", values, "roundFlag");
            return (Criteria) this;
        }

        public Criteria andRoundFlagBetween(Integer value1, Integer value2) {
            addCriterion("round_flag between", value1, value2, "roundFlag");
            return (Criteria) this;
        }

        public Criteria andRoundFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("round_flag not between", value1, value2, "roundFlag");
            return (Criteria) this;
        }

        public Criteria andRemTagNoIsNull() {
            addCriterion("rem_tag_no is null");
            return (Criteria) this;
        }

        public Criteria andRemTagNoIsNotNull() {
            addCriterion("rem_tag_no is not null");
            return (Criteria) this;
        }

        public Criteria andRemTagNoEqualTo(String value) {
            addCriterion("rem_tag_no =", value, "remTagNo");
            return (Criteria) this;
        }

        public Criteria andRemTagNoNotEqualTo(String value) {
            addCriterion("rem_tag_no <>", value, "remTagNo");
            return (Criteria) this;
        }

        public Criteria andRemTagNoGreaterThan(String value) {
            addCriterion("rem_tag_no >", value, "remTagNo");
            return (Criteria) this;
        }

        public Criteria andRemTagNoGreaterThanOrEqualTo(String value) {
            addCriterion("rem_tag_no >=", value, "remTagNo");
            return (Criteria) this;
        }

        public Criteria andRemTagNoLessThan(String value) {
            addCriterion("rem_tag_no <", value, "remTagNo");
            return (Criteria) this;
        }

        public Criteria andRemTagNoLessThanOrEqualTo(String value) {
            addCriterion("rem_tag_no <=", value, "remTagNo");
            return (Criteria) this;
        }

        public Criteria andRemTagNoLike(String value) {
            addCriterion("rem_tag_no like", value, "remTagNo");
            return (Criteria) this;
        }

        public Criteria andRemTagNoNotLike(String value) {
            addCriterion("rem_tag_no not like", value, "remTagNo");
            return (Criteria) this;
        }

        public Criteria andRemTagNoIn(List<String> values) {
            addCriterion("rem_tag_no in", values, "remTagNo");
            return (Criteria) this;
        }

        public Criteria andRemTagNoNotIn(List<String> values) {
            addCriterion("rem_tag_no not in", values, "remTagNo");
            return (Criteria) this;
        }

        public Criteria andRemTagNoBetween(String value1, String value2) {
            addCriterion("rem_tag_no between", value1, value2, "remTagNo");
            return (Criteria) this;
        }

        public Criteria andRemTagNoNotBetween(String value1, String value2) {
            addCriterion("rem_tag_no not between", value1, value2, "remTagNo");
            return (Criteria) this;
        }

        public Criteria andScrUpdateFlagIsNull() {
            addCriterion("scr_update_flag is null");
            return (Criteria) this;
        }

        public Criteria andScrUpdateFlagIsNotNull() {
            addCriterion("scr_update_flag is not null");
            return (Criteria) this;
        }

        public Criteria andScrUpdateFlagEqualTo(Integer value) {
            addCriterion("scr_update_flag =", value, "scrUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andScrUpdateFlagNotEqualTo(Integer value) {
            addCriterion("scr_update_flag <>", value, "scrUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andScrUpdateFlagGreaterThan(Integer value) {
            addCriterion("scr_update_flag >", value, "scrUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andScrUpdateFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("scr_update_flag >=", value, "scrUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andScrUpdateFlagLessThan(Integer value) {
            addCriterion("scr_update_flag <", value, "scrUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andScrUpdateFlagLessThanOrEqualTo(Integer value) {
            addCriterion("scr_update_flag <=", value, "scrUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andScrUpdateFlagIn(List<Integer> values) {
            addCriterion("scr_update_flag in", values, "scrUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andScrUpdateFlagNotIn(List<Integer> values) {
            addCriterion("scr_update_flag not in", values, "scrUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andScrUpdateFlagBetween(Integer value1, Integer value2) {
            addCriterion("scr_update_flag between", value1, value2, "scrUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andScrUpdateFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("scr_update_flag not between", value1, value2, "scrUpdateFlag");
            return (Criteria) this;
        }

        public Criteria andTagLogicName1IsNull() {
            addCriterion("tag_logic_name1 is null");
            return (Criteria) this;
        }

        public Criteria andTagLogicName1IsNotNull() {
            addCriterion("tag_logic_name1 is not null");
            return (Criteria) this;
        }

        public Criteria andTagLogicName1EqualTo(String value) {
            addCriterion("tag_logic_name1 =", value, "tagLogicName1");
            return (Criteria) this;
        }

        public Criteria andTagLogicName1NotEqualTo(String value) {
            addCriterion("tag_logic_name1 <>", value, "tagLogicName1");
            return (Criteria) this;
        }

        public Criteria andTagLogicName1GreaterThan(String value) {
            addCriterion("tag_logic_name1 >", value, "tagLogicName1");
            return (Criteria) this;
        }

        public Criteria andTagLogicName1GreaterThanOrEqualTo(String value) {
            addCriterion("tag_logic_name1 >=", value, "tagLogicName1");
            return (Criteria) this;
        }

        public Criteria andTagLogicName1LessThan(String value) {
            addCriterion("tag_logic_name1 <", value, "tagLogicName1");
            return (Criteria) this;
        }

        public Criteria andTagLogicName1LessThanOrEqualTo(String value) {
            addCriterion("tag_logic_name1 <=", value, "tagLogicName1");
            return (Criteria) this;
        }

        public Criteria andTagLogicName1Like(String value) {
            addCriterion("tag_logic_name1 like", value, "tagLogicName1");
            return (Criteria) this;
        }

        public Criteria andTagLogicName1NotLike(String value) {
            addCriterion("tag_logic_name1 not like", value, "tagLogicName1");
            return (Criteria) this;
        }

        public Criteria andTagLogicName1In(List<String> values) {
            addCriterion("tag_logic_name1 in", values, "tagLogicName1");
            return (Criteria) this;
        }

        public Criteria andTagLogicName1NotIn(List<String> values) {
            addCriterion("tag_logic_name1 not in", values, "tagLogicName1");
            return (Criteria) this;
        }

        public Criteria andTagLogicName1Between(String value1, String value2) {
            addCriterion("tag_logic_name1 between", value1, value2, "tagLogicName1");
            return (Criteria) this;
        }

        public Criteria andTagLogicName1NotBetween(String value1, String value2) {
            addCriterion("tag_logic_name1 not between", value1, value2, "tagLogicName1");
            return (Criteria) this;
        }

        public Criteria andTagLogicName2IsNull() {
            addCriterion("tag_logic_name2 is null");
            return (Criteria) this;
        }

        public Criteria andTagLogicName2IsNotNull() {
            addCriterion("tag_logic_name2 is not null");
            return (Criteria) this;
        }

        public Criteria andTagLogicName2EqualTo(String value) {
            addCriterion("tag_logic_name2 =", value, "tagLogicName2");
            return (Criteria) this;
        }

        public Criteria andTagLogicName2NotEqualTo(String value) {
            addCriterion("tag_logic_name2 <>", value, "tagLogicName2");
            return (Criteria) this;
        }

        public Criteria andTagLogicName2GreaterThan(String value) {
            addCriterion("tag_logic_name2 >", value, "tagLogicName2");
            return (Criteria) this;
        }

        public Criteria andTagLogicName2GreaterThanOrEqualTo(String value) {
            addCriterion("tag_logic_name2 >=", value, "tagLogicName2");
            return (Criteria) this;
        }

        public Criteria andTagLogicName2LessThan(String value) {
            addCriterion("tag_logic_name2 <", value, "tagLogicName2");
            return (Criteria) this;
        }

        public Criteria andTagLogicName2LessThanOrEqualTo(String value) {
            addCriterion("tag_logic_name2 <=", value, "tagLogicName2");
            return (Criteria) this;
        }

        public Criteria andTagLogicName2Like(String value) {
            addCriterion("tag_logic_name2 like", value, "tagLogicName2");
            return (Criteria) this;
        }

        public Criteria andTagLogicName2NotLike(String value) {
            addCriterion("tag_logic_name2 not like", value, "tagLogicName2");
            return (Criteria) this;
        }

        public Criteria andTagLogicName2In(List<String> values) {
            addCriterion("tag_logic_name2 in", values, "tagLogicName2");
            return (Criteria) this;
        }

        public Criteria andTagLogicName2NotIn(List<String> values) {
            addCriterion("tag_logic_name2 not in", values, "tagLogicName2");
            return (Criteria) this;
        }

        public Criteria andTagLogicName2Between(String value1, String value2) {
            addCriterion("tag_logic_name2 between", value1, value2, "tagLogicName2");
            return (Criteria) this;
        }

        public Criteria andTagLogicName2NotBetween(String value1, String value2) {
            addCriterion("tag_logic_name2 not between", value1, value2, "tagLogicName2");
            return (Criteria) this;
        }

        public Criteria andTagLogicName3IsNull() {
            addCriterion("tag_logic_name3 is null");
            return (Criteria) this;
        }

        public Criteria andTagLogicName3IsNotNull() {
            addCriterion("tag_logic_name3 is not null");
            return (Criteria) this;
        }

        public Criteria andTagLogicName3EqualTo(String value) {
            addCriterion("tag_logic_name3 =", value, "tagLogicName3");
            return (Criteria) this;
        }

        public Criteria andTagLogicName3NotEqualTo(String value) {
            addCriterion("tag_logic_name3 <>", value, "tagLogicName3");
            return (Criteria) this;
        }

        public Criteria andTagLogicName3GreaterThan(String value) {
            addCriterion("tag_logic_name3 >", value, "tagLogicName3");
            return (Criteria) this;
        }

        public Criteria andTagLogicName3GreaterThanOrEqualTo(String value) {
            addCriterion("tag_logic_name3 >=", value, "tagLogicName3");
            return (Criteria) this;
        }

        public Criteria andTagLogicName3LessThan(String value) {
            addCriterion("tag_logic_name3 <", value, "tagLogicName3");
            return (Criteria) this;
        }

        public Criteria andTagLogicName3LessThanOrEqualTo(String value) {
            addCriterion("tag_logic_name3 <=", value, "tagLogicName3");
            return (Criteria) this;
        }

        public Criteria andTagLogicName3Like(String value) {
            addCriterion("tag_logic_name3 like", value, "tagLogicName3");
            return (Criteria) this;
        }

        public Criteria andTagLogicName3NotLike(String value) {
            addCriterion("tag_logic_name3 not like", value, "tagLogicName3");
            return (Criteria) this;
        }

        public Criteria andTagLogicName3In(List<String> values) {
            addCriterion("tag_logic_name3 in", values, "tagLogicName3");
            return (Criteria) this;
        }

        public Criteria andTagLogicName3NotIn(List<String> values) {
            addCriterion("tag_logic_name3 not in", values, "tagLogicName3");
            return (Criteria) this;
        }

        public Criteria andTagLogicName3Between(String value1, String value2) {
            addCriterion("tag_logic_name3 between", value1, value2, "tagLogicName3");
            return (Criteria) this;
        }

        public Criteria andTagLogicName3NotBetween(String value1, String value2) {
            addCriterion("tag_logic_name3 not between", value1, value2, "tagLogicName3");
            return (Criteria) this;
        }

        public Criteria andTagLogicName4IsNull() {
            addCriterion("tag_logic_name4 is null");
            return (Criteria) this;
        }

        public Criteria andTagLogicName4IsNotNull() {
            addCriterion("tag_logic_name4 is not null");
            return (Criteria) this;
        }

        public Criteria andTagLogicName4EqualTo(String value) {
            addCriterion("tag_logic_name4 =", value, "tagLogicName4");
            return (Criteria) this;
        }

        public Criteria andTagLogicName4NotEqualTo(String value) {
            addCriterion("tag_logic_name4 <>", value, "tagLogicName4");
            return (Criteria) this;
        }

        public Criteria andTagLogicName4GreaterThan(String value) {
            addCriterion("tag_logic_name4 >", value, "tagLogicName4");
            return (Criteria) this;
        }

        public Criteria andTagLogicName4GreaterThanOrEqualTo(String value) {
            addCriterion("tag_logic_name4 >=", value, "tagLogicName4");
            return (Criteria) this;
        }

        public Criteria andTagLogicName4LessThan(String value) {
            addCriterion("tag_logic_name4 <", value, "tagLogicName4");
            return (Criteria) this;
        }

        public Criteria andTagLogicName4LessThanOrEqualTo(String value) {
            addCriterion("tag_logic_name4 <=", value, "tagLogicName4");
            return (Criteria) this;
        }

        public Criteria andTagLogicName4Like(String value) {
            addCriterion("tag_logic_name4 like", value, "tagLogicName4");
            return (Criteria) this;
        }

        public Criteria andTagLogicName4NotLike(String value) {
            addCriterion("tag_logic_name4 not like", value, "tagLogicName4");
            return (Criteria) this;
        }

        public Criteria andTagLogicName4In(List<String> values) {
            addCriterion("tag_logic_name4 in", values, "tagLogicName4");
            return (Criteria) this;
        }

        public Criteria andTagLogicName4NotIn(List<String> values) {
            addCriterion("tag_logic_name4 not in", values, "tagLogicName4");
            return (Criteria) this;
        }

        public Criteria andTagLogicName4Between(String value1, String value2) {
            addCriterion("tag_logic_name4 between", value1, value2, "tagLogicName4");
            return (Criteria) this;
        }

        public Criteria andTagLogicName4NotBetween(String value1, String value2) {
            addCriterion("tag_logic_name4 not between", value1, value2, "tagLogicName4");
            return (Criteria) this;
        }

        public Criteria andCurrentDataFlagIsNull() {
            addCriterion("current_data_flag is null");
            return (Criteria) this;
        }

        public Criteria andCurrentDataFlagIsNotNull() {
            addCriterion("current_data_flag is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentDataFlagEqualTo(String value) {
            addCriterion("current_data_flag =", value, "currentDataFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDataFlagNotEqualTo(String value) {
            addCriterion("current_data_flag <>", value, "currentDataFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDataFlagGreaterThan(String value) {
            addCriterion("current_data_flag >", value, "currentDataFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDataFlagGreaterThanOrEqualTo(String value) {
            addCriterion("current_data_flag >=", value, "currentDataFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDataFlagLessThan(String value) {
            addCriterion("current_data_flag <", value, "currentDataFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDataFlagLessThanOrEqualTo(String value) {
            addCriterion("current_data_flag <=", value, "currentDataFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDataFlagLike(String value) {
            addCriterion("current_data_flag like", value, "currentDataFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDataFlagNotLike(String value) {
            addCriterion("current_data_flag not like", value, "currentDataFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDataFlagIn(List<String> values) {
            addCriterion("current_data_flag in", values, "currentDataFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDataFlagNotIn(List<String> values) {
            addCriterion("current_data_flag not in", values, "currentDataFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDataFlagBetween(String value1, String value2) {
            addCriterion("current_data_flag between", value1, value2, "currentDataFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDataFlagNotBetween(String value1, String value2) {
            addCriterion("current_data_flag not between", value1, value2, "currentDataFlag");
            return (Criteria) this;
        }

        public Criteria andHourlyDataFlagIsNull() {
            addCriterion("hourly_data_flag is null");
            return (Criteria) this;
        }

        public Criteria andHourlyDataFlagIsNotNull() {
            addCriterion("hourly_data_flag is not null");
            return (Criteria) this;
        }

        public Criteria andHourlyDataFlagEqualTo(String value) {
            addCriterion("hourly_data_flag =", value, "hourlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andHourlyDataFlagNotEqualTo(String value) {
            addCriterion("hourly_data_flag <>", value, "hourlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andHourlyDataFlagGreaterThan(String value) {
            addCriterion("hourly_data_flag >", value, "hourlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andHourlyDataFlagGreaterThanOrEqualTo(String value) {
            addCriterion("hourly_data_flag >=", value, "hourlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andHourlyDataFlagLessThan(String value) {
            addCriterion("hourly_data_flag <", value, "hourlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andHourlyDataFlagLessThanOrEqualTo(String value) {
            addCriterion("hourly_data_flag <=", value, "hourlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andHourlyDataFlagLike(String value) {
            addCriterion("hourly_data_flag like", value, "hourlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andHourlyDataFlagNotLike(String value) {
            addCriterion("hourly_data_flag not like", value, "hourlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andHourlyDataFlagIn(List<String> values) {
            addCriterion("hourly_data_flag in", values, "hourlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andHourlyDataFlagNotIn(List<String> values) {
            addCriterion("hourly_data_flag not in", values, "hourlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andHourlyDataFlagBetween(String value1, String value2) {
            addCriterion("hourly_data_flag between", value1, value2, "hourlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andHourlyDataFlagNotBetween(String value1, String value2) {
            addCriterion("hourly_data_flag not between", value1, value2, "hourlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andDailyDataFlagIsNull() {
            addCriterion("daily_data_flag is null");
            return (Criteria) this;
        }

        public Criteria andDailyDataFlagIsNotNull() {
            addCriterion("daily_data_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDailyDataFlagEqualTo(String value) {
            addCriterion("daily_data_flag =", value, "dailyDataFlag");
            return (Criteria) this;
        }

        public Criteria andDailyDataFlagNotEqualTo(String value) {
            addCriterion("daily_data_flag <>", value, "dailyDataFlag");
            return (Criteria) this;
        }

        public Criteria andDailyDataFlagGreaterThan(String value) {
            addCriterion("daily_data_flag >", value, "dailyDataFlag");
            return (Criteria) this;
        }

        public Criteria andDailyDataFlagGreaterThanOrEqualTo(String value) {
            addCriterion("daily_data_flag >=", value, "dailyDataFlag");
            return (Criteria) this;
        }

        public Criteria andDailyDataFlagLessThan(String value) {
            addCriterion("daily_data_flag <", value, "dailyDataFlag");
            return (Criteria) this;
        }

        public Criteria andDailyDataFlagLessThanOrEqualTo(String value) {
            addCriterion("daily_data_flag <=", value, "dailyDataFlag");
            return (Criteria) this;
        }

        public Criteria andDailyDataFlagLike(String value) {
            addCriterion("daily_data_flag like", value, "dailyDataFlag");
            return (Criteria) this;
        }

        public Criteria andDailyDataFlagNotLike(String value) {
            addCriterion("daily_data_flag not like", value, "dailyDataFlag");
            return (Criteria) this;
        }

        public Criteria andDailyDataFlagIn(List<String> values) {
            addCriterion("daily_data_flag in", values, "dailyDataFlag");
            return (Criteria) this;
        }

        public Criteria andDailyDataFlagNotIn(List<String> values) {
            addCriterion("daily_data_flag not in", values, "dailyDataFlag");
            return (Criteria) this;
        }

        public Criteria andDailyDataFlagBetween(String value1, String value2) {
            addCriterion("daily_data_flag between", value1, value2, "dailyDataFlag");
            return (Criteria) this;
        }

        public Criteria andDailyDataFlagNotBetween(String value1, String value2) {
            addCriterion("daily_data_flag not between", value1, value2, "dailyDataFlag");
            return (Criteria) this;
        }

        public Criteria andMonthlyDataFlagIsNull() {
            addCriterion("monthly_data_flag is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyDataFlagIsNotNull() {
            addCriterion("monthly_data_flag is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyDataFlagEqualTo(String value) {
            addCriterion("monthly_data_flag =", value, "monthlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andMonthlyDataFlagNotEqualTo(String value) {
            addCriterion("monthly_data_flag <>", value, "monthlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andMonthlyDataFlagGreaterThan(String value) {
            addCriterion("monthly_data_flag >", value, "monthlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andMonthlyDataFlagGreaterThanOrEqualTo(String value) {
            addCriterion("monthly_data_flag >=", value, "monthlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andMonthlyDataFlagLessThan(String value) {
            addCriterion("monthly_data_flag <", value, "monthlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andMonthlyDataFlagLessThanOrEqualTo(String value) {
            addCriterion("monthly_data_flag <=", value, "monthlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andMonthlyDataFlagLike(String value) {
            addCriterion("monthly_data_flag like", value, "monthlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andMonthlyDataFlagNotLike(String value) {
            addCriterion("monthly_data_flag not like", value, "monthlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andMonthlyDataFlagIn(List<String> values) {
            addCriterion("monthly_data_flag in", values, "monthlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andMonthlyDataFlagNotIn(List<String> values) {
            addCriterion("monthly_data_flag not in", values, "monthlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andMonthlyDataFlagBetween(String value1, String value2) {
            addCriterion("monthly_data_flag between", value1, value2, "monthlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andMonthlyDataFlagNotBetween(String value1, String value2) {
            addCriterion("monthly_data_flag not between", value1, value2, "monthlyDataFlag");
            return (Criteria) this;
        }

        public Criteria andCloseKindIsNull() {
            addCriterion("close_kind is null");
            return (Criteria) this;
        }

        public Criteria andCloseKindIsNotNull() {
            addCriterion("close_kind is not null");
            return (Criteria) this;
        }

        public Criteria andCloseKindEqualTo(String value) {
            addCriterion("close_kind =", value, "closeKind");
            return (Criteria) this;
        }

        public Criteria andCloseKindNotEqualTo(String value) {
            addCriterion("close_kind <>", value, "closeKind");
            return (Criteria) this;
        }

        public Criteria andCloseKindGreaterThan(String value) {
            addCriterion("close_kind >", value, "closeKind");
            return (Criteria) this;
        }

        public Criteria andCloseKindGreaterThanOrEqualTo(String value) {
            addCriterion("close_kind >=", value, "closeKind");
            return (Criteria) this;
        }

        public Criteria andCloseKindLessThan(String value) {
            addCriterion("close_kind <", value, "closeKind");
            return (Criteria) this;
        }

        public Criteria andCloseKindLessThanOrEqualTo(String value) {
            addCriterion("close_kind <=", value, "closeKind");
            return (Criteria) this;
        }

        public Criteria andCloseKindLike(String value) {
            addCriterion("close_kind like", value, "closeKind");
            return (Criteria) this;
        }

        public Criteria andCloseKindNotLike(String value) {
            addCriterion("close_kind not like", value, "closeKind");
            return (Criteria) this;
        }

        public Criteria andCloseKindIn(List<String> values) {
            addCriterion("close_kind in", values, "closeKind");
            return (Criteria) this;
        }

        public Criteria andCloseKindNotIn(List<String> values) {
            addCriterion("close_kind not in", values, "closeKind");
            return (Criteria) this;
        }

        public Criteria andCloseKindBetween(String value1, String value2) {
            addCriterion("close_kind between", value1, value2, "closeKind");
            return (Criteria) this;
        }

        public Criteria andCloseKindNotBetween(String value1, String value2) {
            addCriterion("close_kind not between", value1, value2, "closeKind");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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