package cat;

import java.util.Random;
import game.Config;

/***
 * Cat4 클래스는 네 번째 고양이 캐릭터 "깜자"를 구현한 클래스입니다.  
 * Base 클래스를 상속받아 고양이의 기본 속성과 행동을 구현하며,  
 * 고양이 탐색 및 포획 로직을 포함합니다.
 * 
 * <p><b>특징:</b></p>
 * <ul>
 *   <li>이름: 깜자</li>
 *   <li>나이: 2살</li>
 *   <li>성별: 암컷</li>
 *   <li>민첩성: 4</li>
 * </ul>
 */
public class Cat4 extends Base {

    /**
     * Cat4의 기본 생성자입니다.  
     * 깜자의 기본 특성들을 초기화합니다.
     * - 이름을 "깜자"로 설정
     * - 나이를 2살로 설정
     * - 성별을 암컷으로 설정
     * - 민첩성을 4로 설정
     * - 포획 확률을 60%로 설정
     */
    public Cat4() {
        this.name = "깜자";
        this.age = 2;
        this.gender = "암컷";
        this.speed = 4;
        this.catchProbability = 60;  // 포획 확률 60%
    }

    /**
     * 깜자를 찾는 메서드입니다.  
     * 50% 확률로 깜자를 발견할 수 있으며, 탐색 결과를 콘솔에 출력합니다.
     *
     * @return true - 깜자를 발견함  
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
        System.out.println("희미한 발자국만 남아있고 고양이는 사라졌네요.");
        return false;
    }

    /**
     * 깜자를 포획하는 메서드입니다.  
     * - 아이템을 사용한 경우({@code item == true})에는 항상 포획에 성공합니다.  
     * - 아이템을 사용하지 않은 경우에는 60% 확률로 포획을 시도합니다.  
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
            System.out.println(Config.GREEN + this.name + Config.RESET + "가(이) 호기심에 손가락을 톡 건드리다 덥석 잡혔다. 날쌔지만 가끔 실수해요.");
            this.isCatch = true; // 포획 성공 상태 변경
            return true;
        }
        System.out.println(Config.RED + "[포획 실패..]");
        System.out.println(Config.GREEN + this.name + Config.RESET + "가(이) 도망쳤다...");
        return false;
    }
}
