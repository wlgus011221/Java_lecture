package game;

import java.util.Scanner;

/***
 * Config 클래스는 게임의 전역 설정값과 공통으로 사용되는 상수들을 관리하는 클래스입니다.
 * 이 클래스는 모든 상수를 `public static final`로 선언하여 어디서든 접근할 수 있습니다.
 * 
 * <p><b>주요 기능:</b></p>
 * <ul>
 *   <li>게임에 등장하는 고양이의 총 수와 관련된 상수</li>
 *   <li>게임의 최대 진행 가능 턴 수</li>
 *   <li>게임에서 공통으로 사용되는 {@link Scanner} 객체</li>
 *   <li>게임에서 사용되는 색상 코드 상수</li>
 * </ul>
 */
public class Config {
    
    /** 
     * 게임에 등장하는 총 고양이의 수 
     * Cat1부터 Cat10까지 총 10마리의 고양이를 의미합니다.
     */
    public static final int CAT_LENGTH = 10;

    /** 
     * 게임의 최대 진행 가능 턴 수 
     * 실질적으로 무제한에 가까운 큰 수로 설정했습니다.
     */
    public static final int GAME_LENGTH = 999999999;

    /** 
     * 게임 전체에서 공통으로 사용되는 {@link Scanner} 객체 
     * 사용자 입력을 받는 데 사용됩니다.
     */
    public static Scanner scanner = new Scanner(System.in);

    /** 
     * 빨간색 출력에 사용되는 ANSI 이스케이프 코드
     * 콘솔에 빨간색 텍스트를 출력합니다.
     */
    public static final String RED = "\u001B[31m";

    /** 
     * 파란색 출력에 사용되는 ANSI 이스케이프 코드
     * 콘솔에 파란색 텍스트를 출력합니다.
     */
    public static final String BLUE = "\u001B[34m";

    /** 
     * 초록색 출력에 사용되는 ANSI 이스케이프 코드
     * 콘솔에 초록색 텍스트를 출력합니다.
     */
    public static final String GREEN = "\u001B[32m";

    /** 
     * 색상 리셋에 사용되는 ANSI 이스케이프 코드
     * 텍스트 색상을 초기화하여 기본 색상으로 돌립니다.
     */
    public static final String RESET = "\u001B[0m";
}
