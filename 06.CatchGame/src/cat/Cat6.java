package cat;

import java.util.Random;
import game.Config;

/***
 * Cat6 클래스는 여섯 번째 고양이 캐릭터 "뚱자"를 구현한 클래스입니다.  
 * Base 클래스를 상속받아 고양이의 기본 속성과 행동을 구현하며,  
 * 고양이 탐색 및 포획 로직을 포함합니다.
 * 
 * <p><b>특징:</b></p>
 * <ul>
 *   <li>이름: 뚱자</li>
 *   <li>나이: 9살</li>
 *   <li>성별: 수컷</li>
 *   <li>민첩성: 6</li>
 * </ul>
 */
public class Cat6 extends Base {

    /**
     * Cat6의 기본 생성자입니다.  
     * 뚱자의 기본 특성들을 초기화합니다.
     * - 이름을 "뚱자"로 설정
     * - 나이를 9살로 설정
     * - 성별을 수컷으로 설정
     * - 민첩성을 6으로 설정
     * - 포획 확률을 40%로 설정
     */
    public Cat6() {
        this.name = "뚱자";
        this.age = 9;
        this.gender = "수컷";
        this.speed = 6;
        this.catchProbability = 40;  // 포획 확률 40%
    }

    /**
     * 뚱자를 찾는 메서드입니다.  
     * 50% 확률로 뚱자를 발견할 수 있으며, 탐색 결과를 콘솔에 출력합니다.
     *
     * @return true - 뚱자를 발견함  
     *         false - 발견하지 못함
     */
    @Override
    public boolean findCat() {
        Random random = new Random();
        int randNumber = random.nextInt(2); // 0 또는 1로 랜덤 결정
        if (randNumber == 1) {
            System.out.println(Config.BLUE + "[탐색 성공]");
            System.out.println(Config.GREEN + this.name + Config.RESET + "을(를) 발견했습니다!!");
            return true;
        }
        System.out.println(Config.RED + "[탐색 실패]" + Config.RESET);
        System.out.println("소리 하나 없이 고요합니다. 고양이도 숨을 죽인 걸까요?");
        return false;
    }

    /**
     * 뚱자를 포획하는 메서드입니다.  
     * - 아이템을 사용한 경우({@code item == true})에는 항상 포획에 성공합니다.  
     * - 아이템을 사용하지 않은 경우에는 40% 확률로 포획을 시도합니다.  
     * 포획에 성공하면 {@code isCatch} 상태가 {@code true}로 변경됩니다.
     *
     * @param item 아이템 사용 여부 (true: 사용, false: 미사용)
     * @return true - 포획 성공  
     *         false - 포획 실패
     */
    @Override
    public boolean catchCat(boolean item) {
        Random random = new Random();
        int randNumber = random.nextInt(100); // 0~99 범위에서 랜덤 확률 생성
        if (randNumber < this.catchProbability || item == true) {  // 확률이 catchProbability 이하일 때 포획 성공
            System.out.println(Config.BLUE + "[잡았다!]");
            System.out.println(Config.GREEN + this.name + Config.RESET + "가(이) 방 한가운데 떡하니 누워 있다가 느릿느릿 붙잡혔다. 움직임엔 관심이 없어요.");
            this.isCatch = true; // 포획 성공 상태 변경
            return true;
        }
        System.out.println(Config.RED + "[포획 실패..]");
        System.out.println(Config.GREEN + this.name + Config.RESET + "가(이) 도망쳤다...");
        return false;
    }
}
