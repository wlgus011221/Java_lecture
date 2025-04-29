package cat;

/**
 * 추상 클래스 Base는 게임 내 고양이의 공통 속성과 기본 행동을 정의합니다.  
 * 모든 고양이 클래스의 부모 클래스로서, 이름, 나이, 성별, 속도 등 공통 필드를 가지고 있으며, 
 * 고양이를 찾고 잡는 기능은 추상 메서드로 정의되어 하위 클래스에서 구현해야 합니다.
 */
public abstract class Base {

    /** 고양이의 이름 */
    public String name;

    /** 고양이의 나이 */
    public int age;

    /** 고양이의 성별 */
    public String gender;

    /** 고양이의 민첩성을 나타내는 속도 (높을수록 잡기 어려움) */
    public int speed;
    
    /** 포획 확률 */
    protected int catchProbability;

    /** 고양이가 잡혔는지를 나타내는 상태 값 (true: 잡힘, false: 안 잡힘) */
    public boolean isCatch = false;

    /**
     * 기본 생성자. 고양이의 이름을 "기본"으로 설정합니다.
     */
    public Base() {
        this.name = "기본";
    }

    /**
     * 고양이를 찾는 동작을 정의하는 추상 메서드입니다.
     *
     * @return 고양이를 찾았으면 true, 그렇지 않으면 false
     */
    public abstract boolean findCat();

    /**
     * 아이템을 사용하여 고양이를 잡는 동작을 정의하는 추상 메서드입니다.
     *
     * @param item 아이템 사용 여부 (true: 아이템 사용, false: 아이템 미사용)
     * @return 고양이를 잡았으면 true, 그렇지 않으면 false
     */
    public abstract boolean catchCat(boolean item);
}
