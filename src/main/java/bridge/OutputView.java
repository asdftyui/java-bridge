package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printStartMsg() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    private String convertToMapComp(String command, String bridgeElem, boolean isEqual) {
        if ((!isEqual && bridgeElem.equals(command)) || (isEqual && !bridgeElem.equals(command))) {
            return " ";
        } else if (isEqual) {
            return "O";
        } else {
            return "X";
        }
    }

    private List<String> convertToMapCompList(String command, List<String> subBridge, boolean isEqual) {
        List<String> mapCompList = new ArrayList<>();

        int index = 0;
        while (index < subBridge.size() - 1){
            mapCompList.add(convertToMapComp(command, subBridge.get(index), true));
            index++;
        }
        mapCompList.add(convertToMapComp(command, subBridge.get(index), isEqual));

        return mapCompList;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, int position, boolean isEqual) {
        List<String> subBridge = bridge.subList(0, position);
        System.out.println("[ " + String.join(" | ",convertToMapCompList("U", subBridge, isEqual)) + " ]");
        System.out.println("[ " + String.join(" | ",convertToMapCompList("D", subBridge, isEqual)) + " ]");
        System.out.println();
    }

    public void printEndMsg() {
        System.out.println("최종 게임 결과");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String successOrFail, int tryCount) {
        System.out.printf("게임 성공 여부: %s\n", successOrFail);
        System.out.printf("총 시도한 횟수: %d\n", tryCount);
    }
}
